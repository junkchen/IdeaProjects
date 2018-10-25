/**
 * annotation 注解
 * @Target 注解用在什么地方（如类，函数，成员变量等）
 * @Retention 注解保存
 * @MustBeDocumented 
 * @Repeatable 在一个元素上是否可以使用多次
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy

fun main(args: Array<String>) {

}