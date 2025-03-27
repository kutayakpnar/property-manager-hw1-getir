# Emlak Yönetim Sistemi

Bu proje, farklı türdeki mülkleri (Ev, Villa ve Yazlık) yönetmek için geliştirilmiş bir Java uygulamasıdır. Nesne yönelimli programlama prensiplerini kullanarak, mülklerin fiyat ve metrekare gibi özelliklerini yönetmeyi sağlar.

## Proje Yapısı

```
patika-getir-hw1/
├── src/
│   ├── Property.java      # Temel mülk sınıfı (abstract)
│   ├── House.java         # Ev sınıfı
│   ├── Villa.java         # Villa sınıfı
│   ├── SummerHouse.java   # Yazlık sınıfı
│   ├── PropertyManager.java # Mülk yönetim servisi
│   └── Main.java          # Ana uygulama sınıfı
└── out/                   # Derlenmiş .class dosyaları
```

## Tasarım Kararları

1. **Soyutlama (Abstraction)**
   - `Property` sınıfı abstract olarak tasarlandı çünkü:
     - Tüm mülk tiplerinin ortak özellikleri (fiyat, metrekare, oda sayısı, salon sayısı) tek bir yerde toplanmalı
     - Doğrudan `Property` nesnesi oluşturulması mantıksal olarak yanlış olurdu
     - Kod tekrarını önlemek için inheritance kullanıldı

2. **Encapsulation (Kapsülleme)**
   - Tüm property'ler private olarak tanımlandı
   - Getter metodları ile dışarıdan erişim sağlandı
   - Bu sayede veri bütünlüğü korundu

3. **Inheritance (Kalıtım)**
   - `House`, `Villa` ve `SummerHouse` sınıfları `Property` sınıfından türetildi
   - Her mülk tipi kendi özel özelliklerini ekleyebilir
   - Ortak özellikler tek bir yerde yönetiliyor

4. **Service Layer**
   - `PropertyManager` sınıfı servis katmanı olarak tasarlandı
   - İş mantığı bu katmanda toplandı
   - Veri yönetimi ve hesaplamalar bu sınıfta yapılıyor

## Fonksiyonlar

### Mülk Listeleme
- `getHouseList()`: Ev listesini döndürür
- `getVillaList()`: Villa listesini döndürür
- `getSummerHouseList()`: Yazlık listesini döndürür

### Fiyat Hesaplamaları
- `getTotalHousePrice()`: Evlerin toplam fiyatını hesaplar
- `getTotalVillaPrice()`: Villaların toplam fiyatını hesaplar
- `getTotalSummerHousePrice()`: Yazlıkların toplam fiyatını hesaplar
- `getTotalPrice()`: Tüm mülklerin toplam fiyatını hesaplar

### Metrekare Hesaplamaları
- `getAverageHouseSquareMeters()`: Evlerin ortalama metrekaresini hesaplar
- `getAverageVillaSquareMeters()`: Villaların ortalama metrekaresini hesaplar
- `getAverageSummerHouseSquareMeters()`: Yazlıkların ortalama metrekaresini hesaplar
- `getAverageSquareMeters()`: Tüm mülklerin ortalama metrekaresini hesaplar

### Filtreleme
- `filterPropertiesByRoomAndLivingRoom()`: Oda ve salon sayısına göre mülkleri filtreler

## Teknik Detaylar

- Java Stream API kullanılarak koleksiyon işlemleri yapıldı
- Lambda ifadeleri ile fonksiyonel programlama yaklaşımı benimsendi
- ArrayList kullanılarak dinamik veri yapıları oluşturuldu
- Clean Code prensipleri gözetildi (anlamlı isimlendirmeler, tek sorumluluk prensibi)

## Çalıştırma

Projeyi derlemek ve çalıştırmak için:

```bash
# Derleme
javac src/*.java -d out

# Çalıştırma
java -cp out Main
```

## Çıktı Örneği

Program çalıştırıldığında:
- Mülk listelerinin sayıları
- Toplam fiyatlar
- Ortalama metrekareler
- Filtrelenmiş mülkler (3 oda, 1 salon)

gibi bilgileri konsola yazdırır. 