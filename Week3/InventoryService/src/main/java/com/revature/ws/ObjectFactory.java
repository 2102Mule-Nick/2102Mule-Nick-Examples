
package com.revature.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.revature.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CanRestock_QNAME = new QName("http://ws.revature.com/", "canRestock");
    private final static QName _CanRestockResponse_QNAME = new QName("http://ws.revature.com/", "canRestockResponse");
    private final static QName _DiscontinueItem_QNAME = new QName("http://ws.revature.com/", "discontinueItem");
    private final static QName _DiscontinueItemResponse_QNAME = new QName("http://ws.revature.com/", "discontinueItemResponse");
    private final static QName _RestockItem_QNAME = new QName("http://ws.revature.com/", "restockItem");
    private final static QName _RestockItemResponse_QNAME = new QName("http://ws.revature.com/", "restockItemResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.revature.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CanRestock }
     * 
     */
    public CanRestock createCanRestock() {
        return new CanRestock();
    }

    /**
     * Create an instance of {@link CanRestockResponse }
     * 
     */
    public CanRestockResponse createCanRestockResponse() {
        return new CanRestockResponse();
    }

    /**
     * Create an instance of {@link DiscontinueItem }
     * 
     */
    public DiscontinueItem createDiscontinueItem() {
        return new DiscontinueItem();
    }

    /**
     * Create an instance of {@link DiscontinueItemResponse }
     * 
     */
    public DiscontinueItemResponse createDiscontinueItemResponse() {
        return new DiscontinueItemResponse();
    }

    /**
     * Create an instance of {@link RestockItem }
     * 
     */
    public RestockItem createRestockItem() {
        return new RestockItem();
    }

    /**
     * Create an instance of {@link RestockItemResponse }
     * 
     */
    public RestockItemResponse createRestockItemResponse() {
        return new RestockItemResponse();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CanRestock }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CanRestock }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "canRestock")
    public JAXBElement<CanRestock> createCanRestock(CanRestock value) {
        return new JAXBElement<CanRestock>(_CanRestock_QNAME, CanRestock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CanRestockResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CanRestockResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "canRestockResponse")
    public JAXBElement<CanRestockResponse> createCanRestockResponse(CanRestockResponse value) {
        return new JAXBElement<CanRestockResponse>(_CanRestockResponse_QNAME, CanRestockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiscontinueItem }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DiscontinueItem }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "discontinueItem")
    public JAXBElement<DiscontinueItem> createDiscontinueItem(DiscontinueItem value) {
        return new JAXBElement<DiscontinueItem>(_DiscontinueItem_QNAME, DiscontinueItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiscontinueItemResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DiscontinueItemResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "discontinueItemResponse")
    public JAXBElement<DiscontinueItemResponse> createDiscontinueItemResponse(DiscontinueItemResponse value) {
        return new JAXBElement<DiscontinueItemResponse>(_DiscontinueItemResponse_QNAME, DiscontinueItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestockItem }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RestockItem }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "restockItem")
    public JAXBElement<RestockItem> createRestockItem(RestockItem value) {
        return new JAXBElement<RestockItem>(_RestockItem_QNAME, RestockItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestockItemResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RestockItemResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "restockItemResponse")
    public JAXBElement<RestockItemResponse> createRestockItemResponse(RestockItemResponse value) {
        return new JAXBElement<RestockItemResponse>(_RestockItemResponse_QNAME, RestockItemResponse.class, null, value);
    }

}
