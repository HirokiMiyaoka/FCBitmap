FCBitmap
===========

## GitHubPages(English)

http://hirokimiyaoka.github.io/FCBitmap/

## JavaDoc

http://hirokimiyaoka.github.io/FCBitmap/doc/

## これなに？

ファミコンで利用されていた52色に近い色を利用したBitmapを単純な文字列で扱えるようにするJARライブラリです。
文字列とサイズからAndriodのBitmapを生成したり、ファミコンカラーのBitmapを文字列に変換できます。

圧縮などはせずアルファベットに置き換えているだけですが、SQLへの保存などが楽にできる……はず。

色コードや色と文字の対応はGitHubPagesの方を参考にしてください。

また変換についてはAndroidでの動作を想定し、メモリをより使わないように設計しているので、処理は若干重いと思います(データが大きくなければ無問題なレベル)。
