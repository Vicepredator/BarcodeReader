# BarcodeReader
A simple barcode/Qrcode reader app for android

This app uses google api to recognise barcodes or QR codes.

I've also created some kind of library to use barcode reader functionality in your projects.


### Library BarcodeReader.java

The library is called BarcodeReader.java and you can find that here [BarcodeReader.java](https://github.com/Vicepredator11/BarcodeReader/blob/master/app/src/main/java/com/vicepredator/barcodereader/BarcodeReader.java)

To use that follow thoose simple steps:

1. Add thoose two lines to your `AndroidManifest.xml`:
  ```XML
  <meta-data android:name="com.google.android.gms.vision.DEPENDENCIES" android:value="barcode"/>
  <uses-permission android:name="android.permission.CAMERA" />
  ```
2. Add this other line to your `build.gradle`:
  ```gradle
  implementation 'com.google.android.gms:play-services-vision:10.0.0'
  ```
3. Add a surface view to your activity to hold your camera preview
4. Create a BarcodeReader object in your activity
  ```java
  BarcodeReader yourBarcodeReader = new BarcodeReader(yourActivity.this, yourSurfaceView);
  ```
4. Set the BarcodeReaderListener, as shown in the example:
  ```java
  yourBarcodeReader.setBarcodeReaderListener(new BarcodeReader.BarcodeReaderListener() {
    @Override
    public void onCodeScanned(String yourReadedBarcode) {
       //Your code here
       //yourReadedBarcode contains the value of the barcode you have read
    }
  });
  ```
5. Finally add ```java yourBarcodeReader.start();``` in your code to start the reader.
