# 実行方法など

- bootRunで実行、 localhost:8080 で Swagger-ui 画面に遷移
- jigReports で build/jig 以下に、クラス図等を出力
  - jig の出力には GraphVizが必要です
  
- [JIGと一緒に開発してみよう](https://github.com/dddjava/Jig/wiki/Tutorial#jig%E3%81%A8%E4%B8%80%E7%B7%92%E3%81%AB%E9%96%8B%E7%99%BA%E3%81%97%E3%81%A6%E3%81%BF%E3%82%88%E3%81%86)

# JR 新幹線　料金ルールを実装してみよう

値オブジェクト（区分オブジェクト、コレックションオブジェクト）を使って、JR の新幹線料金を計算できるようにする。

今回はサンプルとして

- 出発地：東京
- 目的地：新大阪または姫路

とする。

# 料金ルール (Fare System)

料金　＝　運賃　+ 特急料金

## 基本の運賃と特急料金

東京からの運賃と特急料金は以下の通り。

### 運賃(basic fare)

- 新大阪まで 8,910 円
- 姫路まで 10,010　円

### 特急料金(super express surcharge)

#### 指定席(ひかり)

- 新大阪まで　5,490 円
- 姫路まで 5,920　円

#### のぞみ割り増し (additional charge)

ひかりの特急料金に、以下の金額を加算する。

- 新大阪まで 320 円
- 姫路まで 530　円

> 例: 新大阪までのひかり料金
>
> ```5,490円 + 320円 = 5,810円```

### 自由席特急料金 (free seat)

通常期の指定席特急料金から530円引きになります。

> 例：通常期の新大阪までの自由席特急券の料金
>
> ```5,490円 - 530円 = 4,960円```

## 子供料金　(child)

運賃、特急料金ともに、 こどもは半額

（5円の端数は切り捨てます）

> 例：　新大阪までの子供料金
>
> ```運賃　：　8,910円 × 50% = 4,455円```
>
> ```特急料金ひかり : 5,490円 × 50% = 2,745円```
>
> ```合計 : 7,200円```
 

## 割引 (discount)

### 往復割引 (round trip discount)

片道の営業キロが601km以上あれば、「ゆき」と「かえり」の運賃がそれぞれ1割引になります。

東京からの営業キロ

- 新大阪 553km
- 姫路 644km

> 例：東京-姫路の往復料金
>
> ```片道の割引額 10,010円　× 90% = 9,009円　→　10円未満の端数切り捨て 9,000円```
>
> ```割引後の往復運賃　：　9,000円 × 2 = 18,000円```
>
> 2,020円の割引になる

### 団体割引(group discount)

8人以上が同一行程で旅行する場合に適用されます。

- 12月21日〜1月10日　10%
- それ以外 15%

#### 31人以上の割引 

- 31〜50人の普通団体は、1人分の運賃と特急料金が無料になります
- 51人以上の場合は、50人増えるごとに、1人ずつ運賃・特急料金が無料になります。

## 季節(season)による特急指摘席料金の変動

### 季節の区分

- 通常期(regular)
- 閑散期(peak)
- 繁忙期(off-peak)

の三種類

### 12月から１月の繁忙期と閑散期

- 繁忙期: 12月25日〜1月10日（年末年始)
- 閑散期： 1月16日〜30日

### 料金の変動

通常期の指定席特急券に対して、

- 閑散期は　-200円
- 繁忙期には　+200円

### 自由席特急券

季節によって変動しない。
通常期の指定席特急券より530円を引いた金額で年間固定。


#### 参考URL
[JR料金表](https://www.jr-odekake.net/guide/img/shinkansen_ryoukin.pdf)

[団体割引](https://www.jreast.co.jp/kippu/0702.html)


