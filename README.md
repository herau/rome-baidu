# rome-baidu
test case for rome RSS issue


# Tests

`mvn test` will run a Junit Test case which parse two RSS Feed with ROME:

- `http://www.lemonde.fr/m-actu/rss_full.xml` -> OK

- `http://news.baidu.com/ns?cl=2&rn=20&tn=newsrss&word=football` -> KO 
