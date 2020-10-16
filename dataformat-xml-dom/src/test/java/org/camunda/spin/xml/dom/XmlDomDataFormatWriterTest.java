package org.camunda.spin.xml.dom;

import static org.assertj.core.api.Assertions.assertThat;

import org.camunda.spin.xml.SpinXmlElement;
import org.junit.Test;

/**
 * Test xml transformation in DomXmlDataFormatWriter
 *
 * @author Lars Uffmann, 2020-10-16
 */
public class XmlDomDataFormatWriterTest {

  @Test
  public void testFormattedOutputIsDeterministic() {
    String xml = "<order><product>Milk</product><product>Coffee</product></order>";
    SpinXmlElement xml1 = SpinXmlElement.XML(xml);
//    System.out.println("\"" + xml1 + "\"");
    SpinXmlElement xml2 = SpinXmlElement.XML(xml1.toString());
    assertThat(xml2.toString()).isEqualTo(xml1.toString());
    SpinXmlElement xml3 = SpinXmlElement.XML(xml2.toString());
    assertThat(xml3.toString()).isEqualTo(xml2.toString());
//    System.out.println("\"" + xml3 + "\"");
  }

}
