#!/bin/bash

USERNAME='amirgudic_NhlvX8'
ACCESS_KEY='m7xMf8xhqy4exJuAVo3t'

curl -u "$USERNAME:$ACCESS_KEY" \
-X POST "https://api-cloud.browserstack.com/app-automate/upload" \
-F "file=@/Users/amir.gudic/work/appium-ss-template/apps/ApiDemos-debug.apk"