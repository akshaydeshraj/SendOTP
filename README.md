# SendOTP

[![Join the chat at https://gitter.im/axay/SendOTP](https://badges.gitter.im/axay/SendOTP.svg)](https://gitter.im/axay/SendOTP?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
An easy to use wrapper over Msg91's awesome [SendOTP library].

Download
--------

Grab via Maven:
```xml
<dependency>
  <groupId>com.msg91.axay.sendotp</groupId>
  <artifactId>send-otp</artifactId>
  <version>0.1.0</version>
  <type>pom</type>
</dependency>
```
or Gradle:
```groovy
compile 'com.msg91.axay.sendotp:send-otp:0.1.0'
```

Usage
--------

1. Register your app at [Msg91's portal][sendotp]

2. From your `Activity` class, call

  ```java
  SendOtpActivity.start(this);
  ```
3. Make sure the `Activity` implements `OtpVerificationListener`. 

Example :

```java
public class MainActivity extends AppCompatActivity implements OtpVerificationListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SendOtpActivity.start(this);
    }

    @Override
    public void onOtpVerificationSuccess(String mobileNumber, String response) {
        Log.i(TAG, mobileNumber + response);
    }

    @Override
    public void onOtpVerificationFailure(Exception exception) {
        Log.i(TAG, exception.getMessage());
    }

    @Override
    public void onInitiationFailed(Exception exception) {
        Log.i(TAG, exception.getMessage());
    }
}
```


License
=======

    Copyright 2016 Akshay Deshraj

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[sendotp]: https://sendotp.msg91.com/
[SendOTP library]: https://github.com/SendOTP/SendOTPAndroid
