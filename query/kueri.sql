create database basdat
use basdat

/*
create table test
(
	username varchar(12) not null primary key,
	password binary(64)

)
insert into test values('test', HASHBYTES('SHA2_512', '123'))
*/

create table Pembeli (

    username varchar(60) not null primary key,
    no_telp varchar(14) not null,
    password binary(64) not null,
    nama_depan varchar(20) not null, 
    nama_tengah varchar(20), 
    nama_belakang varchar(20), 
    tanggal_lahir date,
    jalan varchar(35) not null,
    kecamatan varchar(20) not null,
    kota varchar(20) not null,
    no_rumah varchar(5),
)

create table Cabang
(
    nama_cabang varchar(50) not null primary key,
    jalan varchar(35) not null,
    kecamatan varchar(20) not null,
    kota varchar(20) not null,
    no_bangunan varchar(5) not null
)

create table Kasir
(
    no_pegawai int identity(100,1) not null primary key,
    no_telp varchar(14) not null,
    password binary(64) not null,
    nama_depan varchar(20) not null, 
    nama_tengah varchar(20), 
    nama_belakang varchar(20), 
    tanggal_lahir date,
    username varchar(60) UNIQUE not null,
    gaji int,
    nama_cabang varchar(50)
    Foreign Key (nama_cabang) REFERENCES Cabang(nama_cabang)
        on DELETE set null
)

create table Pengantar
(
    username varchar(60) not null primary key,
    no_pol varchar(20) not null,
    no_telp varchar(14) not null,
    password binary(64) not null,
    nama_depan varchar(20) not null, 
    nama_tengah varchar(20), 
    nama_belakang varchar(20), 
    gaji int,
    nama_cabang varchar(50)
    Foreign Key (nama_cabang) REFERENCES Cabang(nama_cabang)
        on DELETE set null
)

create table Pembayaran
(
    kode_pembayaran int IDENTITY(10000,1) primary key,
    metode_pembayaran varchar(30) not null,
    total int
)

create table Menu
(
    id_menu int IDENTITY(10,1) not null primary key,
    nama_menu varchar(100) not null,
    harga int
)

create table KeranjangBelanja
(
    username_pembeli varchar(60) not null,
    id_menu int,
    kuantitas int,
    total int
    PRIMARY KEY (username_pembeli,id_menu)
    Foreign Key (username_pembeli) REFERENCES Pembeli(username),
    Foreign Key (id_menu) REFERENCES Menu(id_menu)
)

create table Pesanan
(
    id_pesanan int identity(1,1) not null primary key,
    username_pembeli varchar(60),
    kode_pembayaran int,
    no_pegawai int,
    total int,
    jenis_pengambilan varchar (20),
    username_pengantar varchar(60),
    tgl_pemesanan date
    Foreign Key (kode_pembayaran) REFERENCES Pembayaran(kode_pembayaran)
        on DELETE set null,
    Foreign Key (username_pembeli) REFERENCES Pembeli(username)
        on DELETE set null,
    Foreign Key (no_pegawai) REFERENCES Kasir(no_pegawai)
        on DELETE set null,
    Foreign Key (username_pengantar) REFERENCES Pengantar(username)
        on DELETE set null,
)

create table PesananMenu
(
    id_pesanan int,
    id_menu int,
    kode_pembayaran int,
	kuantitas int
	primary key (id_pesanan, id_menu)
    Foreign Key (id_pesanan) REFERENCES Pesanan(id_pesanan) ON DELETE CASCADE,
    Foreign Key (id_menu) REFERENCES Menu(id_menu) ON DELETE CASCADE,
    Foreign Key (kode_pembayaran) REFERENCES Pembayaran(kode_pembayaran) ON DELETE CASCADE
)

CREATE VIEW view_cabang AS
SELECT *
FROM Cabang

CREATE VIEW view_jumlah_penjualan AS
SELECT SUM(kuantitas) jumlahTotal, kode_pembayaran
FROM PesananMenu
group by kode_pembayaran

CREATE VIEW view_jumlah_untung AS
SELECT SUM(total) jumlahUntung, kode_pembayaran
FROM Pesanan
group by kode_pembayaran

create view view_isi_keranjang as
select * from KeranjangBelanja


