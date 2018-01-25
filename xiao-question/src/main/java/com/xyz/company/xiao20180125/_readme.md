# 都有serialVersionUID,VersionUID一样
- 全部一样的话就反序列化成功
- 增删方法或者属性也能反序列化成功
- 但是修改方法或者属性的话,反序列化会出现java.io.InvalidClassException: com.xyz.company.xiao20180125.User; incompatible types for field id

# 都有serialVersionUID,VersionUID不一样
- 直接反序列化失败

# 都没有serialVersionUID
- 一旦有类有过变化,就会出现反序列化失败

# 一个有serialVersionUID,一个没有的话
- 直接反序列化失败