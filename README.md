

CREATE
```
 curl -i -H "Content-Type:application/json" -d '{"name": "sukesan"}' localhost:8080/user   
 ```

 Windows を使用している場合、上記のコマンドは WSL  で機能します。WSL をインストールできない場合は、一重引用符を二重引用符に置き換え、既存の二重引用符をエスケープする必要がある場合があります
 * 例: 
 ```
 -d "{\"name\": \"sukesan\"}"
 ```

POST 操作へのレスポンスに Location ヘッダーが含まれていることに注意してください。これには、新しく作成されたリソースの URI が含まれます。Spring Data REST には、作成されたばかりのリソースの表現をすぐに返すようにフレームワークを構成するために使用できる 2 つのメソッド (RepositoryRestConfiguration.setReturnBodyOnCreate(…) および setReturnBodyOnUpdate(…)) もあります。RepositoryRestConfiguration.setReturnBodyForPutAndPost(…) は、作成および更新操作の表現レスポンスを有効にするショートカットメソッドです。

```
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/user/1
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Thu, 10 Feb 2022 04:02:53 GMT

{
  "name" : "sukesan",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/user/1"
    },
    "userEntity" : {
      "href" : "http://localhost:8080/user/1"
    }
  }
}% 
```
