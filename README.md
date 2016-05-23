# Github Repos

##Project Overview
Retrieve Github public repositories.

##The Project Used The Following
* RxJava
* RxAndroid
* Retrofit
* RecyclerView
* CardViews
* Tint color for Buttons

##The Setup
###Dependencies
```
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:23.4.0'
    compile 'io.reactivex:rxjava:1.0.+'
    compile 'io.reactivex:rxandroid:0.23.+'
    compile 'com.squareup.retrofit:retrofit:1.9.+'
    compile 'com.android.support:recyclerview-v7:23.4.0'
    compile 'com.android.support:cardview-v7:23.4.0'
}
```
###AndroidManifest
```
<uses-permission android:name="android.permission.INTERNET" /> 
```
##How To Use
Click **Fetch** to get the repositories list and **Clear** to clear the list.
