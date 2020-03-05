./gradlew :baselib:clean

./gradlew :baselib:assembleRelease
./gradlew :baselib:publish -Penv=stag -PpublishAar=true
./gradlew :baselib:publish -Penv=prod -PpublishAar=true
