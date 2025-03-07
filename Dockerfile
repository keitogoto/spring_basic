# Maven付きのJDK 17をベースにする（ビルド環境）
FROM maven:3.9-eclipse-temurin-17 AS builder

# 作業ディレクトリを /app に設定
WORKDIR /app

# ソースコードをコピー（pom.xml だけ先にコピーしてキャッシュを有効にする）
COPY pom.xml .

# 依存関係を事前にダウンロード（キャッシュ利用）
RUN mvn dependency:go-offline

# ソースコードをコピー
COPY . .

# アプリをビルド（テストはスキップ）
RUN mvn clean package -DskipTests

# 実行用の軽量JDK 17をベースにする（ビルド環境を分ける）
FROM eclipse-temurin:17-jdk
WORKDIR /app

# JARファイルを確実にコピー
COPY --from=builder /app/target/spring_basic-0.0.1-SNAPSHOT.jar /app/app.jar

# コンテナ起動時にSpring Bootアプリを実行
CMD ["java", "-jar", "/app/app.jar"]
