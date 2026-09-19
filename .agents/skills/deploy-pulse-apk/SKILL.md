---
name: deploy-pulse-apk
description: Deploys and installs the PULSE-zh APK to connected Android handheld or mobile devices via ADB. Use this skill whenever the user asks to deploy, install, test, or run the APK on their device.
---

# Deploy PULSE-zh APK to Device

## 目的 (Purpose)
自動檢查連接的 Android / 掌機設備（如 Odin、Retroid、手機等），定位或下載最新編譯的 `PULSE-zh` APK，透過 ADB 進行覆蓋安裝，並在掌機上直接啟動 App。

---

## 執行步驟 (Execution Steps)

### 步驟 1：確認設備連線
執行 `adb devices` 確認設備連接狀態：
* 若設備狀態顯示 `unauthorized`：提示使用者查看掌機/手機螢幕，點選「允許 USB 偵錯」與「一律允許」。
* 若未偵測到設備：請使用者透過 USB 連接掌機並開啟開發者選項中的 USB 偵錯，或使用 `adb connect <ip>:<port>` 進行無線偵錯。

### 步驟 2：執行部屬腳本
直接調用專案根目錄的批次檔或 PowerShell 腳本：
```powershell
powershell.exe -ExecutionPolicy Bypass -File "D:\github\pulse\deploy.ps1"
```
或直接執行：
```bat
D:\github\pulse\deploy.bat
```

腳本會自動完成：
1. 檢測已授權的設備序號。
2. 搜尋本地 `app/build/outputs/apk/debug/*.apk`；若無則自動從 GitHub Actions 下載最新雲端產出。
3. 執行 `adb install -r -d` 進行安裝。
4. 執行 `adb shell am start -n com.kei.pulse.zh/com.kei.pulse.MainActivity` 在設備上啟動應用程式。
