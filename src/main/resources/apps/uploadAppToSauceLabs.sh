#!/bin/bash

SAUCE_USERNAME='oauth-amir.gudic-92595'
SAUCE_ACCESS_KEY='777b56b0-bd77-4c45-8cb5-f8ca278e4d02'

curl -u "$SAUCE_USERNAME:$SAUCE_ACCESS_KEY" --location \
--request POST 'https://api.eu-central-1.saucelabs.com/v1/storage/upload' \
--form 'payload=@"/Users/amir.gudic/work/appium-ss-template/apps/ApiDemos-debug.apk"' \
--form 'name="ApiDemos-debug.apk"'