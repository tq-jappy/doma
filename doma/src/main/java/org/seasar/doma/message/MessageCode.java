/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.message;

/**
 * @author taedium
 * 
 */
public enum MessageCode {
    // general
    DOMA0001("パラメータ[{0}]の値[{1}]が不正です。"),
    DOMA0002("予期しない例外が発生しました。原因は次のものです。{0}"),
    DOMA0003("Configの実装クラス[{0}]のメソッド[{1}]からnullが返されました。"),
    DOMA0004("クラス[{0}]のサポートされてないメソッド[{1}]が呼び出されました。"),

    // domain
    DOMA1001("Domainの比較でどちらかの値がnullの場合には、gt()、lt()、ge()、le()、compareTo()の操作はできません。"),
    DOMA1002("Domainの値がnullの場合、この操作はできません。"),
    DOMA1003("このDomainではサポートされていない操作です。"),

    // jdbc
    DOMA2001("SQLの実行結果が1件ではありませんでした。実行されたSQLは次のものです。[{0}]。フォーマットされたSQLは次のものです。[{1}]"),
    DOMA2003("楽観的排他制御により更新処理が失敗しました。実行されたSQLは次のものです。[{0}]。フォーマットされたSQLは次のものです。[{1}]"),
    DOMA2004("一意制約違反により更新処理が失敗しました。実行されたSQLは次のものです。[{0}]。フォーマットされたSQLは次のものです。[{1}]"),
    DOMA2005("Entityクラス[{0}]のインスタンス化に失敗しました。原因は次のものです。{1}"),
    DOMA2006("Domainクラス[{0}]のインスタンス化に失敗しました。原因は次のものです。{1}"),
    DOMA2009("SQLの実行に失敗しました。原因は次のものです。{0}"),
    DOMA2010("SQLファイル[{0}]のデータを取得できませんでした。原因は次のものです。{1}"),
    DOMA2011("SQLファイル[{0}]がクラスパスから見つかりませんでした。"),
    DOMA2012("Connectionのclose()に失敗しました。原因は次のものです。{0}"),
    DOMA2013("Statementのclose()に失敗しました。原因は次のものです。{0}"),
    DOMA2014("ResultSetのclose()に失敗しました。原因は次のものです。{0}"),
    DOMA2015("Connectionの取得に失敗しました。原因は次のものです。{0}"),
    DOMA2016("PreparedStatementの取得に失敗しました。原因は次のものです。{0}"),
    DOMA2017("エンティティ[{0}]のIDプロパティの生成に失敗しました。"),
    DOMA2018("エンティティ[{0}]のIDプロパティの生成に失敗しました。原因は次のものです。{1}"),
    DOMA2019("Domainクラス[{0}]がJDBCの型にマッピングされていません。"),
    DOMA2020("エンティティ[{0}]のIDプロパティ[{1}]に値が設定されていません。"),
    DOMA2021("エンティティ[{0}]のIDプロパティ[{1}]に自動生成のstrategy[{2}]が指定されていますが、DBMS[{3}]ではサポートされていません。"),
    DOMA2022("IDプロパティのないエンティティ[{0}]の更新や削除はできません。"),
    DOMA2023("悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2024("テーブル名もしくはカラム名を指定した悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2025("CallableStatementの取得に失敗しました。原因は次のものです。{0}"),
    DOMA2026("不正なエンティティです。エンティティ[{0}]をクラス[{1}]にキャストできません。"),
    DOMA2027("java.sql.Arrayに関する操作に失敗しました。原因は次のものです。{0}"),
    DOMA2101("SQL[{0}]の解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。文字列リテラルの終了を示すクォテーション['']が見つかりません。"),
    DOMA2102("SQL[{0}]の解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。ブロックコメントの終了を示す文字列[*/]が見つかりません。"),
    DOMA2103("SQL[{0}]の解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。--elseifの終了を示す文字列[--]が見つかりません。"),
    DOMA2104("SQL[{0}]の解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。/*%end*/に対応する/*%if ...*/が見つかりません。"),
    DOMA2105("SQL[{0}]の解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。--elseに対応する/*%if ...*/が見つかりません。"),
    DOMA2106("SQL[{0}]の解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。--elseifに対応する/*%if ...*/が見つかりません。"),
    DOMA2107("SQL[{0}]の解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。複数の--elseが存在します。"),
    DOMA2108("SQL[{0}]の解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。--elseの後ろに--elseifが存在します。"),
    DOMA2109("SQL[{0}]の解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。閉じ括弧に対応する開き括弧が見つかりません。"),
    DOMA2110("SQL[{0}]の解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]の直後にテスト用のリテラルもしくは括弧が見つかりません。"),
    DOMA2111("SQL[{0}]の組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。原因は次のものです。{3}"),
    DOMA2112("SQL[{0}]の組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]に対応するオブジェクトの型[{4}]がCollectionインタフェースのサブタイプではありません。"),
    DOMA2113("SQL[{0}]の組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]に対応するListの要素の型[{4}]がDomainインタフェースのサブタイプではありません。"),
    DOMA2114("SQL[{0}]の組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]に対応するオブジェクトの型[{4}]がDomainインタフェースのサブタイプではありません。"),
    DOMA2115("SQL[{0}]の組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]に対応するListの[{4}]番目の要素がnullです。"),
    DOMA2201("ページング用SQLに変換するには元のSQLにorder by句が指定されている必要があります。"),

    // expression
    DOMA3001("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のメソッド[{3}]の実行に失敗しました。原因は次のものです。{4}"),
    DOMA3002("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のメソッド[{3}]が見つかりませんでした。メソッド名が正しいか確認してください。"),
    DOMA3003("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。変数[{2}]に対応するオブジェクトを解決できませんでした。変数名が正しいか確認してください。"),
    DOMA3004("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。文字列リテラルの終了を示すダブルクォテーション[\"]が見つかりません。"),
    DOMA3005("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]が見つかりませんでした。クラス名が正しいか確認してください。"),
    DOMA3006("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。コンストラクタ[{2}]が見つかりませんでした。コンストラクタのパラメータの数や型が正しいか確認してください。"),
    DOMA3007("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。コンストラクタ[{2}]の実行に失敗しました。原因は次のものです。{3}"),
    DOMA3008("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。比較演算子[{2}]の実行に失敗しました。被演算子のクラスがjava.lang.Comparableを実装していないか、2つの被演算子の型が比較不可能なのかもしれません。原因は次のものです。{3}"),
    DOMA3009("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。比較演算子[{2}]の実行に失敗しました。どちらかの値がnullの場合には、比較できません。"),
    DOMA3010("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。演算子[{2}]に対する被演算子が見つかりませんでした。"),
    DOMA3011("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。サポートされていないトークン[{2}]が見つかりました。"),
    DOMA3012("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。不正な数値リテラル[{2}]が見つかりました。"),
    DOMA3013("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。算術演算子[{2}]の実行に失敗しました。被演算子[{3}]のクラス[{4}]が数値型ではありません。"),
    DOMA3014("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。算術演算子[{2}]の実行に失敗しました。原因は次のものです。{3}"),
    DOMA3015("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。算術演算子[{2}]の実行に失敗しました。被演算子の値がnullです。"),
    DOMA3016("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。文字リテラルの終了を示すクォテーション['']が見つかりません。文字リテラルの長さは1でなければいけません。"),

    // apt
    DOMA4001("戻り値のクラスは更新件数を示すintでなければいけません。"),
    DOMA4002("パラメータの数は1つでなければいけません。"),
    DOMA4003("1つ目のパラメータは@Entityが指定されたインタフェースでなければいけません。"),
    DOMA4005("問い合わせの種別を表すアノテーションが必要です。"),
    DOMA4006("戻り値のListインタフェースには型パラメータが必須です。"),
    DOMA4007("戻り値のListインタフェースの型パラメータは@Entityが指定されたインタフェースもしくはDomainインタフェースを実装した具象クラスでなければいけません。"),
    DOMA4008("戻り値はListインタフェース、@Entityが指定されたインタフェース、Domainインタフェースを実装した具象クラスのいずれかでなければいけません。"),
    DOMA4010("パラメータの型はListインタフェース、@Entityが指定されたインタフェース、Domainインタフェースのサブタイプのいずれかでなければいけません。"),
    DOMA4011("クラス[{0}]に対応するクラス[{1}]のJavaファイル生成に失敗しました。原因は次のものです。{2}"),
    DOMA4012("クラス[{0}]のJavaファイルを生成します。"),
    DOMA4013("クラス[{0}]のJavaファイルを生成しました。"),
    DOMA4014("クラス[{0}]がインタフェースではありません。@Daoもしくは@GenericDaoはインタフェースに対してのみ指定できます。"),
    DOMA4015("クラス[{0}]がインタフェースではありません。@Entityはインタフェースに対してのみ指定できます。"),
    DOMA4016("予期しない例外が発生しました。原因の詳細についてはログ(EclipseならばError Logビュー、javacならばコンソールなど)を確認してください。"),
    DOMA4017("クラス[{0}]がトップレベルではありません。@Daoもしくは@GenericDaoはトップレベルのインタフェースに対してのみ指定できます。"),
    DOMA4018("クラス[{0}]がトップレベルではありません。@Entityはトップレベルのインタフェースに対してのみ指定できます。"),
    DOMA4019("SQLファイル[{0}]がクラスパスから見つかりませんでした。"),
    DOMA4020("@DaoのimplementedBy要素で参照されているため、クラス[{0}]はインタフェース[{1}]を実装しなければいけません。"),
    DOMA4021("次の例外を意図的に無視します。{0}"),
    DOMA4022("戻り値はDomainインタフェースを実装した具象クラスでなければいけません。"),
    DOMA4023("パラメータの数は0でなければいけません。"),
    DOMA4024("@Versionが重複しています。"),
    DOMA4025("[{0}]で始まる名前はDomaにより予約されているため使用できません。"),
    DOMA4026("[{0}]で終わる名前は自動生成されるクラスの名前と重複する可能性があります。"),
    DOMA4027("パラメータのListインタフェースには型パラメータが必須です。"),
    DOMA4028("パラメータのListインタフェースの型パラメータはDomainインタフェースのサブタイプでなければいけません。"),
    DOMA4029("戻り値のListインタフェースには型パラメータが必須です。"),
    DOMA4030("戻り値のListインタフェースの型パラメータはDomainインタフェースのサブタイプでなければいけません。"),
    DOMA4031("戻り値がListインタフェースの場合、@Transientの指定が必須です。"),
    DOMA4032("@Versionを指定する場合、戻り値はNumberDomainインタフェースを実装した具象クラスでなければいけません。"),
    DOMA4033("@GeneratedValueを指定する場合、戻り値はNumberDomainインタフェースを実装した具象クラスでなければいけません。"),
    DOMA4034("@GeneratedValueのstrategyにSEQUECNEを指定する場合、@SequenceGeneratorの指定も必要です。"),
    DOMA4035("@GeneratedValueのstrategyにTABLEを指定する場合、@TableGeneratorの指定も必要です。"),
    DOMA4036("@GeneratedValueを使用する場合、@Idは１つでなければいけません。"),
    DOMA4037("複数の@GeneratedValueが見つかりました。@GeneratedValueは1つでなければいけません。"),
    DOMA4038("EntityListerクラス[{0}]の型パラメータ[{1}]はEntityクラス[{2}]のスーパータイプでなければいけません。"),
    DOMA4039("コンパイルが失敗しているためAPTの処理を中止します。コンパイルが失敗している原因については実行環境（Eclipseやjavac）のエラーメッセージを確認してください。このメッセージが生成された箇所を知りたい場合は、ログ(EclipseならばError Logビュー、javacならばコンソールなど)を確認してください。"),
    DOMA4040("戻り値のクラスは更新件数を示すintの配列でなければいけません。"),
    DOMA4041("パラメータのListインタフェースには型パラメータが必須です。"),
    DOMA4042("パラメータがListインタフェースではありません。"),
    DOMA4043("パラメータのListインタフェースの型パラメータは@Entityが指定されたインタフェースでなければいけません。"),
    DOMA4044("スーパータイプ[{0}]の要素[{1}]に問題があります。原因は次のとおりです。{2}"),
    DOMA4045("@Daoもしくは@GenericDaoが注釈されたインタフェースは@GenericDaoが注釈されているインタフェースのみを継承できます。"),
    DOMA4046("@GenericDaoが注釈されたインタフェースは型パラメータを1つのみ受け取らねばなりません。"),
    DOMA4047("@Daoと@GenericDaoを同時に注釈できません。"),
    DOMA4048("@MappedSuperclassが注釈されたインタフェースは@MappedSuperclassが注釈されているインタフェースのみを継承できます。"),
    DOMA4049("@Entityと@MappedSuperclassを同時に注釈できません。"),
    DOMA4050("@MappedSuperclassが注釈されたインタフェースは型パラメータを受け取ってはいけません。"),
    DOMA4051("@Entityが注釈されたインタフェースは型パラメータを受け取ってはいけません。"),
    DOMA4052("@Entityが注釈されたインタフェースは@Entityもしくは@MappedSuperclassが注釈されたインタフェースのみを継承できます。"),
    DOMA4053("SelectOption型のパラメータは複数指定できません。"),
    DOMA4054("IterationCallback型のパラメータは複数指定できません。"),
    DOMA4055("戻り値の型[{0}]とIterationCallbackの1番目の型パラメータの型[{1}]が一致していません。"),
    DOMA4056("@Selectのiteration要素にtrueを設定した場合、IterationCallback型のパラメータが必要です。"),
    DOMA4057("IterationCallback型のパラメータを利用するには、@Selectのiteration要素にtrueを設定しなければいけません。"),
    DOMA4058("IterationCallbackの2番目の型パラメータは、@Entityが指定されたインタフェースもしくはDomainインタフェースのサブタイプのいずれかでなければいけません。"),
    DOMA4059("@Daoが注釈されたインタフェースは型パラメータを受け取ってはいけません。"),
    DOMA4060("@ResultSetが注釈されていないパラメータの型はDomainインタフェースを実装した具象クラスでなければいけません。"),
    DOMA4061("@ResultSetが注釈されたListの型パラメータは、@Entityが指定されたインタフェースもしくはDomainインタフェースを実装した具象クラスでなければいけません。"),
    DOMA4062("@ResultSetが注釈されたパラメータの型は、Listインタフェースでなければいけません。"),
    DOMA4063("@Functionが注釈されたメソッドの戻り値の型は、Listインタフェース、@Entityが指定されたインタフェース、Domainインタフェースを実装した具象クラスのいずれかでなければいけません。"),
    DOMA4064("@Procedureが注釈されたメソッドの戻り値の型はvoidでなければいけません。"),
    DOMA4065("Listの型パラメータは、@Entityが指定されたインタフェースもしくはDomainインタフェースを実装した具象クラスでなければいけません。"),
    DOMA4066("@Functionもしくは@Procedureが注釈されたメソッドのパラメータには、@In、@InOut、@Out、@ResultSetのいずれかの注釈が必須です。"),
    DOMA4067("SQLファイル[{0}]に含まれるバインド変数[{1}]の最初の要素[{2}]に対応するパラメータが存在しません。"),
    DOMA4068("SQLファイル[{0}]の読み込みに失敗しました。原因は次のものです。{1}"),
    DOMA4069("SQLファイル[{0}]のパースに失敗しました。原因は次のものです。{1}"),
    DOMA4070("SQLファイル[{0}]に含まれるバインド変数[{1}]の[{2}]番目の要素[{3}]が不正な型[{4}]です。"),
    DOMA4071("SQLファイル[{0}]に含まれるバインド変数[{1}]の[{2}]番目の要素[{3}]をパラメータの型[{4}]から解決できません。"),
    DOMA4072("SQLファイル[{0}]に含まれるバインド変数[{1}]の最初の要素[{2}]が不正な型[{3}]です。"),
    DOMA4073("クラス[{0}]のインスタンス化に失敗しました。原因は次のものです。{1}"),
    DOMA4074("メッセージコード[{0}]が次の例外により生成されます。{1}"),
    DOMA4075("戻り値のDomainインタフェースの1番目の型パラメータは{0}でなければいけません。"),
    DOMA4076("パラメータの型は配列型でなければいけません。"),
    DOMA4078("パラメータの数は0でなければいけません。"),

    // other
    DOMA9001("java.io.Closeableのclose()に失敗しました。原因は次のものです。{0}");

    final String message;

    private MessageCode(String message) {
        this.message = message;
    }
}
