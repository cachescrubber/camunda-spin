package org.camunda.spin.xml.dom;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.Reader;
import org.camunda.spin.DataFormats;
import org.camunda.spin.impl.xml.dom.format.DomXmlDataFormat;
import org.camunda.spin.impl.xml.dom.format.DomXmlDataFormatWriter;
import org.camunda.spin.xml.SpinXmlElement;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO: Add a short description of the class here
 *
 * @author Lars Uffmann, 2020-10-16
 * @since TODO: add next version
 */
public class XmlDomDataFormatWriterTest {

  private DomXmlDataFormatWriter writer;
  private Reader inputReader;

  private static final int REWINDING_LIMIT = 256;

  @Before
  public void setUp() {
    DomXmlDataFormat domXmlDataFormat = new DomXmlDataFormat(DataFormats.XML_DATAFORMAT_NAME);
    writer = domXmlDataFormat.getWriter();

  }

  @Test
  public void testFormattedOutput() {
    String xml ="<order><product>Milk</product><product>Coffee</product></order>";
    SpinXmlElement xml1 = SpinXmlElement.XML(xml);
    System.out.println(">>>>");
    System.out.println(xml1);
    System.out.println("<<<<");

    SpinXmlElement xml2 = SpinXmlElement.XML(xml1.toString());
    assertThat(xml2.toString()).isEqualTo(xml1.toString());

    SpinXmlElement xml3 = SpinXmlElement.XML(xml2.toString());
    assertThat(xml3.toString()).isEqualTo(xml2.toString());

    System.out.println(">>>>");
    System.out.println(xml3);
    System.out.println("<<<<");
  }


}
