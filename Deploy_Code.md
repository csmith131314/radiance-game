This page is for those who want to download and build the code just for testing, or even want contribute to the project. Although, assuming that the reader has some coding experience, we kept the guide brief, we included links to external tutorials in case you gets stuck. Note that all the tools We use are cross-platform

# Things you will need #

There are several steps in order to get the code running, but if followed, it will become very easy to run and tamper with the code and even contribute to the project.
Here is a list. We will explain each one of them below:

  1. Eclipse
  1. Android SDK + plugin
  1. Mercurial + plugin
  1. AndEngine clone
  1. Radiance clone


## 1. Eclipse ##

Not much to say. It is an excellent modular IDE for Java and more.
(Java version is fine):

http://www.eclipse.org/

_net-beans_ IDE is also good, but most Android tutorials out there are written with _Eclipse_ so they will be a bit harder to follow.

## 2. Android SDK + plugin ##

The SDK provides the API libraries in order to build Android programs. Another indispensable SDK tool is the Android emulator which allows testing and debugging programs on your computer.
It can be found here:

http://developer.android.com/sdk/index.html (note that the .exe file wont work with win x64. Stick with the .zip)

The SDK executable is actually a modular manager that downloads and installs appropriate packages. _Radiance_ uses API version 8 (Android 2.2), but should also work with version 10 (Android 2.3.3).

After this is done, we need the ADT Plugin for _Eclipse_ in order to mange and Android projects directly from _Eclipse_ and not the command line. It can be installed from the menu > Help > Install new Software. From the following repository we get _Developer Tools_:

```
https://dl-ssl.google.com/android/eclipse/
```


Here is a nice step-by-step tutorial: http://developer.android.com/sdk/installing.html

And another great guide for android development: http://www.vogella.de/articles/Android/article.html

## 3. Mercurial + plugin ##

_Mercurial_ is the version control system that _Radiance_ and _AndEngine_ use. We use it to clone the on-line repositories so we are always up to date with recent code changes. Developers also use _Mercurial_ to commit code patches. It is a powerful tool and we will only be scratching the surface. If using windows, it is recommented to get [tortoiseHG](http://tortoisehg.bitbucket.org/) (which is a shell extension including _Mercurial_). If not, get it and install if for your system here:

http://mercurial.selenic.com/

To get _Mercurial_ work with _Eclipse_, download the plugin with the same procedure as above, this time using the following URL:
```
http://cbes.javaforge.com/update
```

A small guide: http://www.javaforge.com/project/HGE


## 4. AndEngine clone ##

Android SDK does not include but a very primitive opengl API for graphics development. _AndEngine_ is much easier to work with, and its only drawback is that supports only 2D graphics. Another advantage is that it has a very good community and [forum](http://www.andengine.org/forums/).

_Radiance_ uses _AndEngine_ for graphics, so _AndEngine_ must be present on the system and included in the build path. There is a couple of ways to do that. The easiest way is to get the **[AndEngine.jar](http://www.speedyshare.com/files/29911057/andengine.jar)** and include it in the project. The downside of the .jar is that it is static and if new versions of _AndEngine_ are released, the API is not updated (even the download provided above may already be deprecated).

The preferred way is to create a clone of _AndEngine_ repository on a local machine using _Mercurial_ and included it as a library in _Radiance_ project. The _AndEngine_ is hosted on Google-code. Using Eclipse, make a "clone existing Mercurial repository" project (must have mercurial plugin installed). The URL of the repository is:

```
https://code.google.com/p/andengine/
```

It is also recommended to clone _AndEngineExamples_. They are not required by _Radiance_ in any way, but they are helpful to understand the _AndEngine_ functionality. repository URL is: `https://andengineexamples.googlecode.com/hg/andengineexamples`

Here is a quite old-step-by-step tutorial: http://www.andengine.org/forums/tutorials/eclipse-andengine-and-helloworld-t380.html (I suppose there are more tutorials on the forums)

## 5. Radiance clone ##

Now to the actual project! _Radiance_ is hosted on Google-code too, so creating a local clone is the same as above:  make a "clone existing Mercurial repository" project using the URL:

```
https://vagosduke@code.google.com/p/radiance-game/ 
```

Now the final thing to do is include _AndEngine_ project as a library for _Radiance_ (can be done from project properties > Android). Creating a new emulator device is also mandatory for testing the Android API. On the other hand, The core game mechanics are written in plain java so simple test-case classes should be enough for running those parts.

That's about it! You should now have a working clone on your system! Feel free to experiment by writing some test functions. Remember though, the project is far from finished!