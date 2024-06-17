![image](/Users/lumina/Desktop/photo.png )
![image](/Users/lumina/Desktop/photo2.jpg )

### 點餐系統

這個專案是一個基於網頁的點餐系統，使用了Spring Boot作為後端、React作為前端、PostgreSQL作為資料庫，並且部署在Heroku上。它提供了一個用戶友好的界面，讓顧客能夠瀏覽並點選按類別分類的食品項目，管理他們的訂單，完成交易。此外，它還支援新增新商品、檢查庫存、查看訂單歷史等功能，方便後續進行資料分析。

### 功能特點

1. **商品分類和展示**
   - 商品按照類別（例如：前菜、主菜等）進行分類展示，便於用戶快速尋找和選購。

2. **訂單管理**
   - 用戶可以將商品添加至他們的訂單清單中，並即時查看總價格隨著商品增減而更新，使用增加和減少按鈕來調整數量。

3. **確認訂單**
   - 在確認訂單後，用戶可以查看所選商品的詳細食譜，然後進行支付。

4. **支付**
   - 用戶輸入客戶支付的金額，系統計算出應找回的零錢。完成支付後，系統會刷新頁面以進行下一次點餐。

5. **庫存管理**
   - 管理員可以新增新商品，更新現有商品信息，確保庫存充足，避免超賣。

6. **訂單歷史**
   - 用戶可以查看過去的訂單，包括訂單時間、訂購商品和總價格等詳細信息，有助於追蹤消費歷史。

### 技術堆疊

- **前端：** React.js，使用Bootstrap進行UI設計
- **後端：** Spring Boot（Java）
- **資料庫：** PostgreSQL
- **部署：** Heroku

### 功能亮點

- **響應式設計：** 使用Bootstrap確保在不同設備上的兼容性和響應式設計。
- **RESTful API：** 後端提供REST端點，支持前後端之間的無縫通訊，支持CRUD操作。
- **資料庫整合：** 使用PostgreSQL存儲產品信息、訂單詳情和交易記錄。
- **安全性：** 實施身份驗證和授權機制，保護敏感操作。
- **擴展性：** 在Heroku上部署，確保系統在用戶增長時的擴展性和可用性。

這個點餐系統不僅通過直觀的界面增強了用戶體驗，還通過其豐富的功能和強大的技術堆疊支持對食品銷售和客戶行為的高效管理和分析。
