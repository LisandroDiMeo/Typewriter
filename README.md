<h1 align="center"> Typewriter </h1></br>

<p align="center">
:keyboard: A flexible Android Text component that replicates the behavior of a typewriter :keyboard:
</p>

<p align="center">
<img src="https://user-images.githubusercontent.com/22039840/155913161-545c3b2c-7784-4666-bafb-85ad76d272a0.gif" width="32%"/>
</p>

## Including in your project 🧐

Currently looking for release hosting! For now, you can download the repository and manually add it from *Project Structure* option in Android Studio. 

## How to use 🤔

It's usage is quite simple! Since is based on a TextView, you can simply add treat it as one. 

- In your layout XML file:
```xml
      <com.example.typewriter.Typewriter
        android:id="@+id/typewriter"
        android:textSize="24sp"
        android:fontFamily="@font/robotomono_lightitalic"
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
  findViewById<Typewriter>(R.id.typewriter).startTypewriter() // To Start Typewriter animation. 
```

### Configuration 🔧

- Change the speed of the text 🏃:
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
- [ ] Release in github to make an easier integration in projects.
- [ ] Add cooler use case of Typewriter component.
- [ ] Add Compose Compatibility. 

## License 📖

