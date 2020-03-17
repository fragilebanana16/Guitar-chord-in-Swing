# Guitar-chord-in-Swing
Chords recorder in Java swing
## 1.Requirements
- Java 13.0.2
- jl1.0.1.jar
## 2.3rd party music player in jar
cmd line needs jar option class path.Like:

```
javac -cp .\jl1.0.1.jar .\MP3Player.java
java -cp ".\jl1.0.1.jar;" MP3Player
```

[API](http://www.javazoom.net/javalayer/docs/docs1.0/index.html）
## 3.Multi-thread

in order to do sth else once you clicked play the music button,you will need multi-thread, override the method run, and your own behavior in it.

## 4.Exception interrupt method to stop the thread
To start with, thread has a method stop() to stop, now this method is deprecated, you will need some tricks to stop the thread, like exception or other methods.
Use interrupt to set bit of the thread then stop the thread, why this bit can cause stop of the thread?In <<Core Java Vol1>> 14.2 the author says exception in thread can cause stop of it.

[REF](http://c.biancheng.net/view/1186.html)


## 5.Note the habit
.java files should be put in the dir root, .class should be put in dir util,whats more, if you are using javac,java, aka,cmd line to run the code, please dont mix the .class and .java distractedly.



## 6.Potential errors explained
```
Exception in thread "Thread-0" java.lang.NoClassDefFoundError: javazoom/jl/player/Player
        at util.music.MP3Player.play(MP3Player.java:24)
        at util.music.MusicThread.run(MusicThread.java:25)
Caused by: java.lang.ClassNotFoundException: javazoom.jl.player.Player
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:602)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
```

Try option classpath
```
javac -cp ".;.\util\jl1.0.1.jar" Demo.java
java -cp ".;.\util\jl1.0.1.jar" Demo
```
[Swing API](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)


## 7.What are $1.class,$2.class in my dir after javac?
Anonymous class exisits,in listener we have a class override his father with no name, $1.class is the  mark of the anonymous class

- Future version will consider splash screen and system tray


## 8.Addition:How to upload whole dir to repo
```
git clone Your_repo_add
cd Your_repo
git add . 
git commit -m "msg" 
git push -u origin master 
```
## 9.Result
![image](https://github.com/fragilebanana16/Guitar-chord-in-Swing/blob/master/naive.png)
