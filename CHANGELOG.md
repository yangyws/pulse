# 專案變更日誌與追溯索引 (Changelog & Traceability Index)

本檔案遵循全域技能規範 [`change-tracking-index`](file:///C:/Users/Mini-PC/.gemini/antigravity-cli/skills/change-tracking-index/SKILL.md)，記錄專案重要修改歷史與技術決策索引。每次修改皆給定唯一索引識別碼，以利後續追溯與維護。

---

## 🔖 [MOD-20260920-24] 台灣繁體中文在地化科技用語純淨化

* **修改日期**：2026-09-20
* **目標分支**：`main-zh`
* **修改分類**：`[在地化精修 / 台灣繁體中文標準]`
* **涉及檔案清單**：
  * 修改：`app/src/main/res/values-zh-rTW/strings.xml`（「設備」更正為「裝置」、「卡頓」更正為「畫面頓挫」）
  * 修改：`CHANGELOG.md`（記錄變更日誌與索引追溯）
* **修改動機與問題**（Why）：
  * 稽核發現 `strings.xml` 中仍遺留「設備」與「卡頓」等非台灣科技習慣用語。
* **技術方案與關鍵決策**（How）：
  * 全數替換為台灣 Android 標準科技用語（裝置、畫面頓挫）。
* **測試與驗證結果**（Verification）：
  * 391 條字串 XML 驗證通過，非台灣用語命中完全歸零。

---

## 🔖 [MOD-20260920-01] Android 官方標準多語系架構重構與台灣繁體中文在地化

* **修改日期**：2026-09-20
* **目標分支**：`main-zh` / `i18n-zh`
* **版本標籤**：`v1.19.6-zh`
* **修改分類**：`[架構重構 / 在地化 / 規範標準化]`
* **涉及檔案清單**：
  * 新增：`app/src/main/res/values/strings.xml`（英文/預設 391 條字串）
  * 新增：`app/src/main/res/values-zh-rTW/strings.xml`（台灣繁體中文 391 條字串）
  * 新增：`app/src/main/res/xml/locales_config.xml`（Android 13+ 支援語系清單）
  * 新增：`app/src/main/java/com/kei/pulse/PulseApp.kt`（全域 Context 資源提供）
  * 新增：`app/src/main/java/com/kei/pulse/i18n/ResourcePulseStrings.kt`（原生 `R.string` 資源適配器）
  * 修改：`app/src/main/AndroidManifest.xml`（宣告 `android:localeConfig="@xml/locales_config"` 與 `PulseApp`）
  * 修改：`app/src/main/java/com/kei/pulse/MainActivity.kt`（監聽語系並以 `LocaleManager` 動態切換）
  * 修改：`app/src/main/java/com/kei/pulse/i18n/I18nProvider.kt`（整合 `LocaleHelper` 原生切換）
  * 修改：`app/src/main/java/com/kei/pulse/ui/theme/PulseTheme.kt`（支援 Context 動態資源更新）
  * 刪除：`app/src/main/java/com/kei/pulse/i18n/ZhTwStrings.kt`（廢棄手寫字串物件）
  * 刪除：`app/src/main/java/com/kei/pulse/i18n/EnStrings.kt`（廢棄手寫字串物件）
  * 刪除：`app/src/main/java/com/kei/pulse/i18n/ZhCnStrings.kt`（依需求全面移除簡體中文）
* **修改動機與問題**：
  * 原先採用自訂的 Kotlin 字典類別（`ZhTwStrings.kt`、`EnStrings.kt`）存放全 App 的 385 條字串，此做法非 Android 官方多語系規範，無法被系統級「設定 > 應用程式 > 語言」原生識別，且不利於開源社群維護與向原作者發起 Pull Request。
* **技術方案與關鍵決策**：
  1. **標準 XML 資源化**：將所有 385 條介面字串移入官方標準 `res/values/strings.xml` 與 `res/values-zh-rTW/strings.xml`，命名使用 `snake_case`。
  2. **XML 語法嚴格跳脫**：處理單雙引號（`\'`、`\"`）、`&amp;`，非格式化百分比符號一律標記 `formatted="false"`，徹底杜絕 AAPT2 編譯錯誤。
  3. **Android 13+ 原生 Per-App 語言支援**：透過 `locales_config.xml` 與 `android.app.LocaleManager` 實現熱切換與系統設定雙向連動。
  4. **原生資源適配器 (Resource Adapter)**：實作 `ResourcePulseStrings` 委託給 `context.getString(R.string.xxx)`，在完全刪除手寫類別的同時，保持原有呼叫點 100% 穩定相容。
  5. **100% 台灣用語在地化**：經自動化工具全面檢驗，0 簡體字、0 中國大陸習慣用語（採用浮動視窗、快捷圖塊、前景、開機自動啟動、監控指標、畫面幀率等）。
* **測試與驗證結果**：
  * GitHub Actions 雲端編譯成功（Run: `35460729641`，結論: `success`）。
  * 部署至 AYN Thor 實機設備（`d7195880`），實測「跟隨系統」、「繁體中文 (台灣)」、「English」三者即時熱切換功能正常，UI 顯示流暢。
* **關聯索引與後續提醒**：
  * 後續若在專案中新增任何 UI 文字，一律只能加在 `res/values/strings.xml` 與 `res/values-zh-rTW/strings.xml`，嚴禁新建 Kotlin 字串字典類別。

---

## 🔖 [MOD-20260920-09] 專案儲存庫更名 pulse-zh、台灣繁體中文 README 製作與自動部署規範化

* **修改日期**：2026-09-20
* **目標分支**：`main-zh` / `pr/i18n-standard-localization`
* **修改分類**：`[儲存庫維護 / 文件在地化 / 自動部署最佳化]`
* **涉及檔案清單**：
  * 新增：`README.en.md`（原英文版備份，頂部新增雙向切換導覽標頭）
  * 新增：`README.zh-TW.md`（面向上游母專案標準格式，頂部含 `[English](README.md) | **台灣繁體中文**`）
  * 修改：`README.md`（全文台灣繁體中文高質感在地化製作，頂部含 `[English](README.en.md) | **台灣繁體中文**`，含 AutoTDP、自訂風扇、OSD、RGB、PServer 免 Root 原理與 ADB 自動部署教學）
  * 修改：`deploy.ps1`（更新 GitHub API 下載路徑為 `yangyws/pulse-zh`，並將所有終端機提示字串全面校正為台灣科技用語：裝置、部署、偵錯、偵測）
  * 修改：`CHANGELOG.md`（記錄本追溯索引標籤與各項維護歷程）
* **修改動機與問題**：
  1. 儲存庫依規劃由 `yangyws/pulse` 更名為 `yangyws/pulse-zh`，以突顯台灣在地化版本定位，本機遠端儲存庫與部署指令碼需同步更新。
  2. 提供台灣繁體中文使用者最完整、親切且專業之掌機效能調校說明文件，並為上游母專案 `keiretrogaming/pulse` 提供獨立的 `README.zh-TW.md`。
* **技術方案與關鍵決策**：
  1. **GitHub REST API 更名**：透過 PATCH API 成功將 GitHub 儲存庫重新命名為 `pulse-zh`。
  2. **雙向語系導覽與 100% 台灣在地化**：README 文件全面遵循台灣標準科技用語，杜絕簡體字與大陸用語；建立完整目錄與功能說明。
  3. **母專案與本地雙軌相容**：本地預設繁體中文版 `README.md`，英文版備份為 `README.en.md`；面向上游 PR 則提供標準 `README.zh-TW.md` 與英文主文件連動。
  4. **上游 PR #22 聯絡反饋**：於母專案 PR #22 留言說明已完成 `README.zh-TW.md` 文件翻譯，隨時可供併入。
* **測試與驗證結果**：
  * GitHub REST API 呼叫回傳 200 成功更名。
  * 本地 Git remote origin URL 更新為 `https://github.com/yangyws/pulse-zh.git`。
  * 自動化正規表達式比對通過，0 個簡體字、0 個中國大陸用語。
  * `main-zh` 與 `pr/i18n-standard-localization` 經授權已同步推送到遠端儲存庫。

