Local database kurulumu (mysql, postgresql veya herhangi bir database)

Java spring uygulaması ayağa kaldırılması,
İki adet tablo yer alamalı ve bu tabloların birbirleriyle bağı olmalıdır. (Örn: şirket ve çalışan gibi),
Java spring uygulamasında ekleme,silme,güncelleme,listeleme gibi servisler yer almalıdır ve responseda yapılan işlem detayı return edilmelidir.
Ekleme,silme,güncelleme,listeleme işlemlerini postman vb ile işlem yapılabilmelidir. Bu adımlar sırasıyla izlenip java uygulaması üzerinden database’ e kayıt atılmalı (Herhangi bir kayıt olabilir fark etmez. Database'de bir tablo açılıp o tabloya değer girilmesi java isteği üzerinden). Daha sonra aynı istek atılan uygulama ile (örnek postman ...) get ve list java spring endpointleri çağırılarak, database e atılan kayıt response olarak dönülmeli. MVC deki model ve kontroller akışının güzel kurgulanması ve uygulama ayağı nasıl kaldırılıp servislerin nasıl kullanıldığına dair bir döküman hazırlanmalıdır. Bu proje için kaynak kodu ile iletilmesi gerekmektedir.

Teknolojiler
Java 8
Spring Boot
Spring Data Jpa
Spring Validation
openapi- swagger
lombok
Maven
