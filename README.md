# ImmutableCollections
Immutable `Parcelable` collections for Android

This library spawned from a desire to have a small set of immutable `Parcelable` collections on Android. 
[Guava](https://github.com/google/guava) immutable collections were evaluated and were evaluated and found to have too 
much bloat. [Solid](https://github.com/konmik/solid) was evaluated, and found to be promising, but we didn't want to
introduce another `Stream`ing library to our code base as we already used [RxJava](https://github.com/ReactiveX/RxJava)
heavily.

For now this library is just a simple set of immutable, `Parcelable` collections which were taken from the 
[Solid](https://github.com/konmik/solid) library and had the streaming code removed. I'm sure there are plenty of
performance improvements that can be had, and an API that could be added to more easily create modified collections.

Pull requests are welcome.
