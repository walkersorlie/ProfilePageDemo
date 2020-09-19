1. If you don't have Android Studio installed, you can [download it here](https://developer.android.com/studio) and follow the instructions [here](https://developer.android.com/studio/install) to install it.
  - Alternatively, if you already have Android Studio installed, this project requires Android Studio 4.0 or newer. You can find instructions to update your version of Android Studio [here](https://developer.android.com/studio/intro/update).
2. Clone this repository into the directory of your choosing
3. Open this project in Android Studio by clicking `File` -> `New` -> `Import Project...`. Navigate to the directory where you cloned the project repository and select it.
4. During the project's build phase you will probably get an error along the lines of `Module 'app': platform 'android-30' not found.` if you don't have the `Android 10.0+ (R)` SDK installed. We'll have to open the Android SDK Manager and install all missing platforms. Open the SDK Manager (top right-hand corner, looks like a little box with a download arrow) and select `Android 10.0+ (R)`, which is `API Level 30`. Click `apply`, accept the terms and conditions and continue. Once the download is finished, select the `Build` tab on the top toolbar of the IDE and select `Rebuild` and the project should build successfully.
5. If you have an Android device that is running API level 30 then you can test this app on your own device, following instructions [here](https://developer.android.com/studio/run/device) if you have never debugged an app on your Android device. If you don't have an Android device running API level 30 or no Android device at all, we will have to install a virtual device for testing (step 6).
6. To use the Android Virtual Device (AVD) Manager, follow the instructions [here](https://developer.android.com/studio/run/emulator) and follow the headings `Install the emulator` and `Run an app on the Android Emulator`.
  - When installing a device with the AVD Manager, select the device you wish to use (Pixel 3, Pixel 3A, etc.), and on the `System Image` page you will have to download the `API 30` image (strap in, it takes a hot minute). Once the image is finished installing you will be back to the `System Image` page. Select the image we just downloaded (release name `R`). On the next page keep all the default settings as-is. The virtual device is now ready!
7. We can now run the app! Under the `Run` tab on the top toolbar in the IDE select `Run 'app'`. The app will take a minute or so to boot up the virtual device. The app should then be running!