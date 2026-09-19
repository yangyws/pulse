---
name: git-push-guard
description: Mandatory safety protocol for Git operations. Use whenever working with Git to ensure no code is pushed to remote repositories without explicit user confirmation.
---

# Git Push Guard & 安全推送規範

## 核心防護原則 (Mandatory Rule)
**嚴禁在未經使用者明確確認的情況下私自執行 `git push`！**

在任何情況下，若需將程式碼推送到遠端 Git 儲存庫（如 GitHub / GitLab / Gitea 等），必須停下來向使用者請求確認，並等待使用者回覆許可後方可執行。

---

## 具體執行規範 (Execution Protocol)

### 1. 本地安全操作（可依任務需要自動執行）
* 檔案檢查與比對：`git status`, `git diff`, `git log`
* 本地分支操作：`git branch`, `git checkout`, `git switch`
* 本地暫存與提交：`git add`, `git commit`

### 2. 推送前強制確認程序（Push Confirmation）
在完成本地 commit 並準備推送前，**必須遵循以下步驟**：
1. **停止執行 `git push`**。
2. 向使用者清楚列出：
   - 本次預計推送的遠端目標（例如：`origin main`）
   - 本次提交（Commit）的摘要與修改重點
3. **明確向使用者詢問**：
   - 範例：「本地已完成修改與提交，請問是否確認推送到遠端 GitHub？」
4. **等待使用者回覆**：
   - 只有在使用者明確給出肯定回覆（例如：「確認」、「推上去」、「同意」、「好」）時，才可調用 `git push`。
   - 若使用者未指示推送或表示暫緩，則保持在本地 commit 狀態，不得進行推送。
