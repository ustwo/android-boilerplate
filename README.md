# Android Boilerplate
[![License Apache 2.0](https://img.shields.io/badge/license-Apache%202.0-green.svg)](https://github.com/ustwo/android-boilerplate/blob/master/LICENSE.md)
[![ustwo twitter](https://img.shields.io/badge/twitter-@ustwo-blue.svg)](http://twitter.com/ustwo)
[![Platform Android](https://img.shields.io/badge/platform-Android-blue.svg)](https://www.android.com)

## Description
Android boilerplate project to use as a reference when starting new Android projects. It provides basic architecture, tools and guidelines that we use when developing Android apps.

## Modules
This project consists of the following modules:

- app, Phone & tablet module

## Tools
* [Android Studio](https://developer.android.com/studio/index.html), Provides the fastest tools for building apps on every type of Android device.
* [Gradle](https://gradle.org/), An open source build automation system.

## Signing and secrets
The repository contains two files responsible for secrets and signing; `ci-keys.cipher` and `release.keystore.cipher` respectivly. Both files have been encrypted using openssl aes-256-cbc with the key `ustwoopensource`. These files are intended solely as placeholders to allow you to make release builds and **need** to be replaced before releasing to the app store.

### Editing secrets
To add, view or edit secrets you first need to decrypt them using openssl:
```
openssl aes-256-cbc -d -out ci-keys -in ci-keys.cipher -k ustwoopensource
```

This will creat a file called `ci-keys` which you can then edit as needed and encrypt again using:
```
openssl aes-256-cbc -e -in ci-keys -out ci-keys.cipher -k ustwoopensource
```

The file `ci-keys.cipher` will then be ready to commit.

The same process can be used with `release.keystore.cipher` when you need to replace or change the keystore with your own details.

### CI setup
For the secrets and keystore to be used by your CI server you will need to export the environment variable `CI_SECRETS_KEY` with the default key listed above or your own if you've re-encrypted the secrets and keystore yourself. You will also need to ensure that openssl is added as a dependency / installed by default.

## Updating gitignore
The gitignore file is generated using [GitIgnore.io](https://gitignore.io) and using [Android and Intellij](https://www.gitignore.io/api/android,intellij) for the selected technologies. This allows for easy updating when tools are updated or otherwise when required.

## Contact
[open.source@ustwo.com](mailto:open.source@ustwo.com)
