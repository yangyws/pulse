---
name: taiwan-traditional-chinese
description: Mandatory standard for all Chinese communication, code localization, documentation, and comments. Enforces pure Taiwan Traditional Chinese (zh-TW) style and terminology, strictly prohibiting Simplified Chinese and mainland China regional phrasing.
---

# 台灣繁體中文與用語風格規範 (Taiwan Traditional Chinese Standard)

## 核心原則 (Core Principle)
只要使用中文溝通、回答、撰寫文檔、程式碼在地化或輸出訊息，**一律嚴格遵循台灣繁體中文（zh-TW）風格，絕對不得使用中國大陸簡體字、大陸用語或大陸語法風格**。

---

## 詞彙對照與禁用規則 (Terminology Rules)
必須使用台灣常見的科技與資訊標準用語，嚴禁直接使用中國大陸慣用語：

| 台灣標準繁體中文 (必須使用) | 中國大陸用語 (嚴格禁止) |
| :--- | :--- |
| **程式碼** | 代码 |
| **專案** | 项目 |
| **儲存庫** | 仓库 |
| **預設** | 默认 |
| **支援** | 支持 |
| **檔案** | 文件 |
| **資料夾** | 文件夹 |
| **記憶體** | 内存 |
| **螢幕** | 屏幕 |
| **更新率** | 刷新率 |
| **最佳化** | 优化 |
| **資訊 / 訊息** | 信息 |
| **偵錯** | 调试 |
| **軟體 / 硬體** | 软件 / 硬件 |
| **網路** | 网络 |
| **伺服器** | 服务器 |
| **浮動視窗 / 懸浮視窗** | 悬浮窗 |
| **裝置 / 設備** | 设备 (依情境優先用「裝置」) |
| **設定 / 設定檔** | 配置 (如情境適合用「設定」) |
| **快捷圖塊** | 磁贴 / 图块 |

---

## 程式碼在地化規範 (Localization Standard)
在為任何專案進行中文翻譯與本地化時：
1. 語系必須指定為 `zh-TW` / `values-zh-rTW` / 繁體中文。
2. 所有字元必須為繁體中文字。
3. 語意必須通順符合台灣在地語感，切忌生硬直譯。
