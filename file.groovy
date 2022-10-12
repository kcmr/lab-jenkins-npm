/* groovylint-disable CompileStatic, ImplicitClosureParameter */

List<String> shoppingList = [
  'manzanas',
  'naranjas',
  'kiwis',
  'patatas'
]

shoppingList.each {
  println "Buy: ${it}"
}
