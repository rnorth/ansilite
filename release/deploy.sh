#!/usr/bin/env bash

set -x

openssl aes-256-cbc -K $encrypted_6444aba4c864_key -iv $encrypted_6444aba4c864_iv -in release/codesigning.asc.enc -out release/codesigning.asc -d
gpg --fast-import release/codesigning.asc

./mvnw versions:set -DnewVersion=$TRAVIS_TAG
./mvnw deploy -P sign,build-extras,!test-only -DskipTests --settings release/settings.xml
