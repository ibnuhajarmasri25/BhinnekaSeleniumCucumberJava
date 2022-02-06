@Scenario
Feature: Bhinneka Selenium Web Automation
  Background:
    Given Initiate Browser
    Given Setup setTestData
    Given Navigate to webiste Bhinneka
  Scenario Outline: Hasil Pencarian Dengan Manipulasi Jumlah di product detail dan Keranjang(TASK A)
    Given Pergi Ke Beranda Website Bhinneka
    And Klik Page Login
    Then Masukan Email dan Password
    And Melakukan Pencarian dengan detail "<Keyword>"
    And Tambah jumlah Produk pada halaman detail produk "<Jumlah Product Detail>"
    And Tambah jumlah Produk pada halaman keranjang "<Jumlah Product Keranjang>"
    And Logout
#    And View Report
    Examples:
    | Keyword   | Jumlah Product Detail | Jumlah Product Keranjang |
    | HELM KYT  | 4                     | 7                        |

  Scenario Outline: Produk dari daftar kategori dengan manipulasi filter pada daftar produk
    Given Pergi Ke Beranda Website Bhinneka
    And Klik Page Login
    Then Masukan Email dan Password
    And Melakukan Pencarian dengan detail "<Keyword>"
    And Filter Daftar Kategori
    And Logout

    Examples:
    | Keyword |
    | Helm    |





