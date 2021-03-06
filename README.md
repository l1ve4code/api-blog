<h1 align="center" style="display: flex; align-items: center; justify-content: center;"><img src="https://www.dariawan.com/media/images/tutorial-spring-logo.width-1024.png" width="80" style="margin-right: 10px">  BLOG API</h1>

[![License](https://img.shields.io/badge/License-Apache/2.0-blue.svg)](https://github.com/arkivanov/MVIKotlin/blob/master/LICENSE)

### Об API

Данное API представляет серверную часть для блога, которое позволяет создавать/комментировать/лайкать посты.

### Функционал

* ***Регистрация*** / ***Авторизация***.
* ***Публикация*** / ***комментирование*** / ***оценка новостей***.
* ***Управление ролями***

### Ссылки

<table>
<tr><td>HTTP</td><td> URL</td><td>BODY</td><td>RESPONSE</td></tr>
<tr><td>POST</td><td>/api/v1/auth/register</td>
<td>

```json
{
  "surname": "Testov",
  "name": "Test",
  "username": "test183",
  "email": "test@mail.ru",
  "password": "qwertyuiop"
}
```

</td>
<td>

```json
{
  "id": 1,
  "surname": "Testov",
  "name": "Test",
  "username": "test183",
  "email": "test@mail.ru",
  "password": "$2a$10$O1Z.FscFc7XeavMHAon6G.FrJURrh5eFCBL9kIoPeEjX9OAoA.G12",
  "role_name": [
    "ROLE_USER"
  ]
}
```

</td>
</tr>
<tr><td>POST</td><td>/api/v1/auth/login</td>
<td>

```json
{
  "username": "test183",
  "password": "qwertyuiop"
}
```

</td>
<td>

```json
{
  "username": "test183",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaGlwYWV2Iiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY1MzU1NDgzNywiZXhwIjoxNjUzNTU4NDM3fQ.84S7e6dOATdwFGzi_kuDqWQM82qk-ATOJW4U3Ct_Jdg"
}
```

</td></tr>
<tr><td>GET</td><td>/api/v1/blog/news</td><td>-</td>
<td>

```json
[
  {
    "id": 1,
    "title": "Amazing news",
    "text": "Sample text",
    "owner_name": "Testov Test",
    "comments": [
      {
        "id": 2,
        "text": "Super",
        "news_id": 1
      }
    ],
    "like_amount": 1,
    "comment_amount": 1
  },
  {
    "id": 2,
    "title": "Wow",
    "text": "Sample text",
    "owner_name": "Testov Test",
    "comments": [],
    "like_amount": 1,
    "comment_amount": 0
  }
]
```

</td></tr>
<tr><td>GET</td><td>/api/v1/blog/news/{id}</td><td>-</td>

<td>

```json
{
  "id": 1,
  "title": "Amazing news",
  "text": "Sample text",
  "owner_name": "Testov Test",
  "isLiked": true,
  "comments": [
    {
      "id": 2,
      "text": "Super",
      "news_id": 1
    }
  ],
  "like_amount": 1,
  "comment_amount": 1
}
```

</td></tr>
<tr><td>POST</td><td>/api/v1/admin/news</td>

<td>

```json
{
  "title": "News",
  "text": "Sample text"
}
```

</td>
<td>

```json
{
  "id": 1,
  "title": "News",
  "text": "Sample text",
  "owner_name": "Testov Test",
  "like_amount": 0,
  "comment_amount": 0
}
```

</td></tr>
<tr><td>DELETE</td><td>/api/v1/admin/news/{id}</td><td>-</td>

<td>

```json
{
  "id": 1,
  "title": "News",
  "text": "Sample text",
  "owner_name": "Testov Test",
  "like_amount": 0,
  "comment_amount": 0
}
```

</td></tr>
<tr><td>POST</td><td>/api/v1/user/comment/{id}</td>
<td>

```json
{
  "text": "Good!"
}
```

</td>
<td>

```json
{
  "id": 26,
  "text": "Good!",
  "news_id": 1
}
```

</td></tr>
<tr><td>DELETE</td><td>/api/v1/admin/comment/{id}</td><td>-</td>

<td>

```json
{
  "id": 26,
  "text": "Good!",
  "news_id": 1
}
```

</td></tr>
<tr><td>POST</td><td>/api/v1/user/like/{id}</td><td>-</td>

<td>

```json
{
  "id": 23,
  "user_id": 17,
  "news_id": 18
}
```

</td></tr>
<tr><td>DELETE</td><td>/api/v1/user/like/{id}</td><td>-</td>

<td>

```json
{
  "id": 23,
  "user_id": 17,
  "news_id": 18
}
```

</td></tr>
</table>

### Технологии

* Язык: **Java**
* Технологии: **Spring MVC, Spring WEB, Spring Security**
* База данных: **MySQL**
* Паттерн: **MVC**

## Установка

Напишите в терминале, после инициализируйте проект при помощи ***Intellij IDEA***:

```git
git clone https://github.com/l1ve4code/api-blog.git
```

## Автор

* Telegram: **[@live4code](https://t.me/live4code)**
* Email: **steven.marelly@gmail.com**
