# XIntro - Java Android Library
**XIntro** is a Java Android Library for android developers. The library use to build introduction activity for android application.

[![Maven Central Status](https://img.shields.io/badge/Maven%20Central-UP-brightgreen.svg)]([maven])
[![jCenter Status](https://img.shields.io/badge/jCenter-UP-brightgreen.svg)]([jCenter])
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-XIntro%20-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3368)
[![GitHub Status](https://img.shields.io/badge/GitHub-UP-brightgreen.svg)]([GitHub])
[![Project status](https://img.shields.io/badge/Project%20Status-Development-yellow.svg)]()
[![Project version](https://img.shields.io/badge/Version-1.1-blue.svg)]()

[maven]: #maven
[jCenter]: #gradle
[GitHub]: https://github.com/yonatankahana/xintro


![example image](http://up416.siz.co.il/up2/dm4ttemzgmyx.png "Example image")

##Notes
1. This project is still in DEVELOPMENT
2. The wiki is still in progress...

##Example application 
In the example application (in Google Play!) you can test the options that XIntro give you.
[Download example application](https://play.google.com/store/apps/details?id=com.github.yonatankahana.introexample)

## <a id="gradle">Gradle
```
compile 'com.github.yonatankahana:xintro:1.1'
```

## <a id="maven">Maven (for the oldfags)
```
<dependency>
  <groupId>com.github.yonatankahana</groupId>
  <artifactId>xintro</artifactId>
  <version>1.1</version>
  <type>pom</type>
</dependency>
```
##Features
- [x] Fully customizable: alot of parameters to customize a beautiful introduction.
- [x] Using Glide as default image loader: (has option to change to PicassoImageLoader and SimpleImageLoader) or creating custom image loader.
- [x] Create introduction programmatically with XintroActivityBuilder.
- [x] Create introduction by extending XintroActivity and override initialize() method.
- [x] Set your page transformer for the ViewPager.

##Milestones
- [ ] Full RTL support
- [ ] More fragment impl's for selection
- [ ] Wiki pages
- [ ] Supoort lower SDK levels


##Report issue
If you found any bug or any idea how to make this project better, please [Create an Issue](https://github.com/yonatankahana/xintro/issues/new).

##Getting started
Checkout the [wiki](https://github.com/yonatankahana/xintro/wiki/) for examples and getting started guide.

##Compatibility
XIntro can be used from min sdk 16.

##Example
![example gif](http://i.giphy.com/l4hLMr2VC8WHcp7Z6.gif "Example gif")



##Licenses
[GNU GPL 3.0](http://www.gnu.org/licenses/gpl-3.0.en.html)

[Glide](https://github.com/bumptech/glide/blob/master/LICENSE)

[Picasso](https://github.com/square/picasso/blob/master/LICENSE.txt)







Tags: XIntro AppIntro android introduction library lib libs tools xintroduction easy builder

