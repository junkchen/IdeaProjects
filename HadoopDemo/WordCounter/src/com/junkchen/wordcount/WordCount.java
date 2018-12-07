package com.junkchen.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

public class WordCount {

    public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {
        private IntWritable one = new IntWritable(1);
        private Text word = new Text();

        @Override
        protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            // 去除标点符号
            String text = value.toString().replaceAll("[\\pP‘’“”]", "");
            StringTokenizer itr = new StringTokenizer(text);
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                context.write(word, one);
            }
        }
    }

    public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable value : values) {
                sum += value.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        String basePath = "hdfs://localhost:9000";
        Path inputPath = new Path(basePath, "/input/sp.txt");
//        Path inputPath = new Path(basePath, "/input/FlowLayout.java");
        Path outputPath = new Path(basePath, "/output");
        Job job = Job.getInstance(conf, "Word count");
        FileSystem fs = outputPath.getFileSystem(conf);
        if (fs.isDirectory(outputPath)) {
            fs.delete(outputPath, true);
        }
        job.setJarByClass(WordCount.class);
        // Set Mapper
        job.setMapperClass(TokenizerMapper.class);
        // Set combiner
        job.setCombinerClass(IntSumReducer.class);
        // Set reducer
        job.setReducerClass(IntSumReducer.class);
        // Set output key type
        job.setOutputKeyClass(Text.class);
        // Set output value type
        job.setOutputValueClass(IntWritable.class);
        // Set the path of file input
        FileInputFormat.addInputPath(job, inputPath);
        FileOutputFormat.setOutputPath(job, outputPath);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
