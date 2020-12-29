package Chapter4


import Chapter4.json._

object json {
  sealed trait JSON{
    def stringify: String =
      this match {
        case JsNumber(value) => value.toString
        case JsString(value) => s"$value"
        case JsBoolean(value) => value.toString
        case JsNull => "null"
        case SeqCell(head, SeqEnd) => s"${head.stringify}"
        case SeqCell(head, tail) => s"${head.stringify}, ${tail.stringify}"
        case ObjectCell(key, value, tail) => s"{$key:$value} ${tail.stringify}"
        case ObjectEnd => "{}"
        case SeqEnd => "[]"
      }
  }
  final case class JsNumber(value: Double) extends JSON
  final case class JsString(value: String) extends JSON
  final case class JsBoolean(value: Boolean) extends JSON
  case object JsNull extends JSON
  sealed trait JsSequence extends JSON
  sealed trait JsObject extends JSON

  final case class SeqCell (head: JSON, tail: JsSequence) extends JsSequence
  case object SeqEnd extends JsSequence

  final case class ObjectCell (key: String, value: JSON, tail: JsObject) extends JsObject
  case object ObjectEnd extends JsObject

  SeqCell(JsString("a string"), SeqCell(JsNumber(1.0), SeqCell(JsBoolean (true), SeqEnd))).stringify
  // res0: String = ["a string", 1.0, true]

  ObjectCell(
    "a", SeqCell(JsNumber(1.0), SeqCell(JsNumber(2.0), SeqCell(JsNumber
    (3.0), SeqEnd))), ObjectCell(
      "b", SeqCell(JsString("a"), SeqCell(JsString("b"), SeqCell( JsString("c"), SeqEnd))),
      ObjectCell(
        "c", ObjectCell("doh", JsBoolean(true),
          ObjectCell("ray", JsBoolean(false), ObjectCell("me", JsNumber(1.0), ObjectEnd))),
        ObjectEnd )
    ) ).stringify

  // res1: String = {"a": [1.0, 2.0, 3.0], "b": ["a", "b", "c"], "c": {" doh": true, "ray": false, "me": 1.0}}
}

//object Main extends App{
//  println(SeqCell(JsString("a string"), SeqCell(JsNumber(1.0), SeqCell(JsBoolean (true), SeqEnd))).stringify)
//  println(ObjectCell(
//    "a", SeqCell(JsNumber(1.0), SeqCell(JsNumber(2.0), SeqCell(JsNumber
//    (3.0), SeqEnd))), ObjectCell(
//      "b", SeqCell(JsString("a"), SeqCell(JsString("b"), SeqCell( JsString("c"), SeqEnd))),
//      ObjectCell(
//        "c", ObjectCell("doh", JsBoolean(true),
//          ObjectCell("ray", JsBoolean(false), ObjectCell("me", JsNumber(1.0), ObjectEnd))),
//        ObjectEnd )
//    ) ).stringify)
//}