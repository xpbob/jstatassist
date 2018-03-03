# jstatassist
show the info of jvm memory 

# 使用场景
我们可以使用jstat -gccause查看gc原因，如果是system.gc。调用的地方就有两种可能，一种是业务代码，一种是直接内存满了，jdk自己调用的。  
通过这个工具可以获取到直接内存的最大值设置以及已使用值。  
这样方便我们在不了解代码的情况下，推断问题点。

# 使用方式
1. 进入jstatassist目录下，可以查看到有Run.bat
1. jps查看java进程id
1. Run.bat pid


# 注意
1. 现在只提供了windows的脚本，如果linux就自己java执行吧
1. 需要有JAVA_HOME的环境变量
