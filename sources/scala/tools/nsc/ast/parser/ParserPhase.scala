/* NSC -- new scala compiler
 * Copyright 2005 LAMP/EPFL
 * @author  Martin Odersky
 */
// $Id$
package scala.tools.nsc.ast.parser;

abstract class ParserPhase(prev: Phase)
	 extends StdPhase(prev)
            with Scanners
	    with Parsers {
    def name = "parser";
    def apply(unit: global.CompilationUnit): unit = {
      global.informProgress("parsing " + unit);
      unit.body = new Parser(unit).parse();
    }

              /** this is the first phase */
  override def >= (other: Phase) = this == other;

}
