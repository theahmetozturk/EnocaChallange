Spring Boot Local Database Örneği
Hakkında
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
lombok
Maven

Proje Path Bilgileri
employee-controller
PUT
/v1/employee/update
Personel güncellemek için yapılan method. Personel id zorunlu alandır.

POST
/v1/employee/save
Yeni Personel eklemek için yapılan method.

GET
/v1/employees/{employeeId}
id'si bilinen personelin bilgilerini çağıran method.

GET
/v1/employees
Tüm Personel Kayıtlarını getiren method.

DELETE
/v1/employee/delete/{id}
Personel silmek için yapılan method. Personel id si verilen kayıt varsa DB den silinecektir.

company-controller
PUT
/v1/companies/update
Şirket bilgilerini güncellemek için kullanılan method. method içinde id zorunlu alandır.

POST
/v1/companies
Yeni Bir Şirket kaydı açmak için kullanılan method.


GET
/v1/companies/{companyId}
id ye göre şirket bilgilerini çekmek için kullanılır.


GET
/v1/companies
Kayıtlı olan tüm şirket bilgilerini çekmek için kullanılır.

DELETE
/v1/companies/delete/{companyId}
Kayıtlı şirket Silme işleminin yapıldığı method. Uyarı İlişkili personel varsa silmeye izin vermicektir. Silmeden önce personelleri farklı bir şirkete taşımanız gerekir.
