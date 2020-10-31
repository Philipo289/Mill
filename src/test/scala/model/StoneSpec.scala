package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class StoneSpec extends AnyWordSpec with Matchers{
  "A Stone" should{
    "be set" in{
      val color_int = 1
      Stone(color_int).isSet should be(true)
    }
    "not be set" in{
      val color_int = 0
      Stone(color_int).isSet should be(false)
    }
    "have value 2" in {
      val color_int = 2
      Stone(color_int).value should be(2)
    }
  }
}
