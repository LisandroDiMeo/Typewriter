<h1 align="center"> Typewriter </h1></br>

<p align="center">
:keyboard: A flexible Android Text component that replicates the behavior of a typewriter
</p>

<p align="center">
      <a href="https://jitpack.io/#LisandroDiMeo/Typewriter"><img alt="Jitpack" src="https://jitpack.io/v/LisandroDiMeo/Typewriter.svg"/></a>
      <a href="https://opensource.org/licenses/MIT"><img alt="Licence" src="https://img.shields.io/badge/license-MIT-red"/></a>
</p>
      
<p align="center">
<img src="https://user-images.githubusercontent.com/22039840/155913161-545c3b2c-7784-4666-bafb-85ad76d272a0.gif" width="32%"/>
</p>

## Including in your project 🧐

Inside build.gradle you may put the dependency 

```gradle
      implementation 'com.github.LisandroDiMeo:Typewriter:0.1.5'
```

And since it's hosted on [Jitpack](https://jitpack.io), you also need to add the Jitpack repository to your repositories list on settings.gradle or root build.gradle

- settings.gradle
```gradle
      dependencyResolutionManagement {
          repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
          repositories {
              google()
              mavenCentral()
              // ... other repos ...
              maven { url "https://jitpack.io" }
          }
      }
```
- root build.gradle
```gradle
      repositories {
            google()
            mavenCentral()
            // ... other repos ...
            maven { url "https://jitpack.io" }
      }

```

## How to use 🤔

It's usage is quite simple! Since is based on a TextView, you can simply add treat it as one. 

- In your layout XML file:
```xml
    <com.lisandrodm.typewriter.Typewriter
        android:id="@+id/writer"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        android:textColor="@color/black"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
- And in your code to start the typewriter animation:
```kotlin
  findViewById<Typewriter>(R.id.writer).startTypewriter() // To Start Typewriter animation. 
```

### Configuration 🔧

- Change the text speed 🏃:
```xml
app:writerSpeed="fast or slow or normal" 
```
This, taken a linear interpolator, is the wait time to each character to show up. 

- Change the animation interpolator (which is linear by default) 📈:
```kotlin
      findViewById<Typewriter>(R.id.typewriter).animationInterpolator = AccelerateInterpolator()
```
The only condition is that the function that the interpolator represents has to be *monotonic* (e.g. **Acelerate Interpolator**).

## Next Steps ☑️

- [x] Make a simple typewriter component.
- [ ] Render a list of strings in one typewriter component sequentially (in delete and write fashion).
- [ ] Add testing & code cov.
- [ ] Add performance checks.
- [x] Release in github to make an easier integration in projects.
- [ ] Add cooler use case of Typewriter component.
- [ ] Add Compose Compatibility. 

## License 📖

[MIT License](https://github.com/LisandroDiMeo/Typewriter/blob/main/LICENSE)

<a title="User:ZyMOS, Public domain, via Wikimedia Commons" href="https://commons.wikimedia.org/wiki/File:License_icon-mit.svg"><img width="256" alt="License icon-mit" src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/License_icon-mit.svg/256px-License_icon-mit.svg.png"></a>

