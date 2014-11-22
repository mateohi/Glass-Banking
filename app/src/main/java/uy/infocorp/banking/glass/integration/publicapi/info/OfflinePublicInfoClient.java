package uy.infocorp.banking.glass.integration.publicapi.info;

import uy.infocorp.banking.glass.integration.publicapi.info.dto.PublicInfoDTO;
import uy.infocorp.banking.glass.util.http.HttpUtils;

public class OfflinePublicInfoClient {

    private static final String OFFLINE_JSON = "{\n" +
            "banner: {\n" +
            "advertisingImages: [\n" +
            "{\n" +
            "advertisingImageId: 7,\n" +
            "order: 1,\n" +
            "placeHolderConfigId: 3,\n" +
            "imageId: 5,\n" +
            "actions: [\n" +
            "{\n" +
            "advertisingImageActionId: 7,\n" +
            "advertisingImageId: 7,\n" +
            "metadata: {\n" +
            "url: \"\",\n" +
            "fullQualifiedName: \"Infocorp.Advertising.BusinessEntities.AdvertisingGroups.AdvertisingImageActionMetadata, Infocorp.Advertising.BusinessEntities, Version=1.0.0.0, Culture=neutral, PublicKeyToken=f43e0188197ab34e\",\n" +
            "knownTypes: [ ]\n" +
            "}\n" +
            "}\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "advertisingImageId: 6,\n" +
            "order: 2,\n" +
            "placeHolderConfigId: 3,\n" +
            "imageId: 4,\n" +
            "actions: [\n" +
            "{\n" +
            "advertisingImageActionId: 6,\n" +
            "advertisingImageId: 6,\n" +
            "metadata: {\n" +
            "url: \"https://www.santander.pr/Personas/PrestamosHipotecarios/Conozca.aspx\",\n" +
            "fullQualifiedName: \"Infocorp.Advertising.BusinessEntities.AdvertisingGroups.AdvertisingImageActionMetadata, Infocorp.Advertising.BusinessEntities, Version=1.0.0.0, Culture=neutral, PublicKeyToken=f43e0188197ab34e\",\n" +
            "knownTypes: [ ]\n" +
            "}\n" +
            "}\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "advertisingImageId: 8,\n" +
            "order: 3,\n" +
            "placeHolderConfigId: 3,\n" +
            "imageId: 3,\n" +
            "actions: [\n" +
            "{\n" +
            "advertisingImageActionId: 8,\n" +
            "advertisingImageId: 8,\n" +
            "metadata: {\n" +
            "url: \"\",\n" +
            "fullQualifiedName: \"Infocorp.Advertising.BusinessEntities.AdvertisingGroups.AdvertisingImageActionMetadata, Infocorp.Advertising.BusinessEntities, Version=1.0.0.0, Culture=neutral, PublicKeyToken=f43e0188197ab34e\",\n" +
            "knownTypes: [ ]\n" +
            "}\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "],\n" +
            "creationDate: \"2014-06-07T01:10:00.637Z\",\n" +
            "isAutoRotate: true,\n" +
            "modifiedDate: \"2014-06-07T01:10:00.637Z\",\n" +
            "placeHolderConfigId: 3,\n" +
            "placeHolderId: 3,\n" +
            "rotationTime: 5000\n" +
            "},\n" +
            "newsFeed: [\n" +
            "{\n" +
            "backgroundColor: \"#d9d9d9\",\n" +
            "body: \"Pensado para proyectos o negocios de Pymes que están iniciando su proceso o que requieren un impulso para crecer. Público objetivo: Personas Jurídicas Características y beneficios: Crédito amortizable por UYU 100.000 en 12 CUOTAS mensuales Sin antigüedad Aprobación en 24 hs. Requisitos y Documentación a presentar: Inscripción de la Pyme en DGI. No tener antecedentes crediticios negativos. Antecedentes crediticios positivos de los socios en los 2 últimos años, durante 6 meses. Antigüedad máxima de 18 meses (pasando este tiempo ya puede acceder a mayor crédito). Más Crédito Mi Proyecto Público objetivo: Personas Jurídicas Características y beneficios: UYU 150.000 Se puede tomar en crédito amortizable hasta en 18 cuotas mensuales, Tarjeta de Crédito y/o Descuento de cheques diferidos. Antigüedad mínima 18 meses. Aprobación en 24 hs. Requisitos y Documentación a presentar: Inscripción de la Pyme en DGI No tener antecedentes crediticios negativos.\",\n" +
            "creationDate: \"2014-07-07T19:36:09.123Z\",\n" +
            "date: \"2014-07-07T07:00:00Z\",\n" +
            "detailFormat: \"textAndImage\",\n" +
            "detailImageId: 50,\n" +
            "expirationDate: \"2015-07-08T07:00:00Z\",\n" +
            "id: 3,\n" +
            "isDeleted: false,\n" +
            "listFormat: \"textAndLeftImage\",\n" +
            "listImageId: 51,\n" +
            "modifiedDate: \"2014-07-07T19:36:09.123Z\",\n" +
            "moreInformationUrl: \"https://www.santander.com.uy/Pymes/Credito/credito_mi_proyecto.asp\",\n" +
            "publishedDate: \"2014-07-07T07:00:00Z\",\n" +
            "subtitle: \"Santander el banco de las Pymes creó Mi Proyecto, un crédito amortizable por 100.000 pesos uruguayos\",\n" +
            "textColor: \"#3c78d8\",\n" +
            "title: \"Crédito Mi Proyecto\"\n" +
            "},\n" +
            "{\n" +
            "backgroundColor: \"#ffff00\",\n" +
            "body: \"\",\n" +
            "creationDate: \"2014-07-07T20:01:39.51Z\",\n" +
            "date: \"2014-07-08T07:00:00Z\",\n" +
            "detailFormat: \"banner\",\n" +
            "detailImageId: 52,\n" +
            "expirationDate: \"2015-07-08T07:00:00Z\",\n" +
            "id: 4,\n" +
            "isDeleted: false,\n" +
            "listFormat: \"text\",\n" +
            "modifiedDate: \"2014-07-07T20:06:06.553Z\",\n" +
            "moreInformationUrl: \"asas://www.santander.com.uy/Pymes/Credito/credito_pyme.asp\",\n" +
            "publishedDate: \"2014-07-07T07:00:00Z\",\n" +
            "subtitle: \"Es una línea de crédito en pesos o dólares destinada a cubrir las necesidades de la empresa, permitiéndole planificar las actividades de su empresa y tener mayor rapidez en la conclusión de negocios.\",\n" +
            "textColor: \"#93c47d\",\n" +
            "title: \"Crédito Pyme\"\n" +
            "},\n" +
            "{\n" +
            "backgroundColor: \"#000000\",\n" +
            "body: \"Cada día más cerca suyo Crédito concedido a individuos para cubrir diversas necesidades de financiamiento con propósito personal. Solicite hoy el Super Préstamo Personal 1 y simplifique sus finanzas haciendo un sólo pago mensual. Tasas desde 4.75% APR 2 a 12 meses. Beneficios Tasas de interés desde 4.75% APR 2 a 12 meses Términos de pago de 12 a 84 meses Pagos Fijos Contestación Rápida Puede solicitar aquí o llamando a la Superlínea Santander al 787-281-3000, 1-800-915-3030 o en cualquiera de nuestras sucursales Banco en línea gratis, a través de eBanking Beneficios Adicionales Seguro de vida Seguro de incapacidad Seguro de desempleo Requisitos Ingreso mensual fijo 1 año o más de empleo Ser mayor de 21 años, emancipado o casado legalmente Ser residente en Puerto Rico\",\n" +
            "creationDate: \"2014-07-08T13:00:30.62Z\",\n" +
            "date: \"2014-07-08T07:00:00Z\",\n" +
            "detailFormat: \"text\",\n" +
            "expirationDate: \"2015-07-08T07:00:00Z\",\n" +
            "id: 5,\n" +
            "isDeleted: false,\n" +
            "listFormat: \"text\",\n" +
            "modifiedDate: \"2014-07-08T13:00:30.62Z\",\n" +
            "moreInformationUrl: \"\",\n" +
            "publishedDate: \"2014-07-08T07:00:00Z\",\n" +
            "subtitle: \"\",\n" +
            "textColor: \"#ffffff\",\n" +
            "title: \"Super préstamo personal\"\n" +
            "},\n" +
            "{\n" +
            "backgroundColor: \"rgb(220, 220, 220)\",\n" +
            "body: \"La cuenta que le ofrece TODO lo esencial Ahora la cuenta TODO Santander le ofrece TODO lo esencial: cheques, ahorros, línea de reserva 1, descuentos y otros grandes beneficios. Beneficios Cuenta de cheques y ahorro combinada Paga intereses en ambas porciones 3 Tarjeta de débito Santander Express MasterCard, Gratis 8, 15 Transacciones en cajeros automáticos de Banco Santander Puerto Rico, Gratis 9 Primera orden de 25 cheques modelo corporativo, Gratis Línea de Reserva 1 Depósito Directo de nómina, Gratis 4 Pago Express, Gratis Banco en Casa, Gratis Banco en Línea a través de eBanking, Gratis Transferencias entre cheques y ahorros TODO Santander por cajero automático, sucursales, Banca Telefónica e Internet, Gratis Servicio de eStatement, Gratis 14 Beneficios Adicionales 5 Descuento en préstamos personales de 1% del APR vigente y es requisito abrir o tener una cuenta TODO Santander y acogerse al servicio de pago directo. Sujeto a aprobación de crédito. Sólo aplica a préstamos personal no garantizados 6 Cubierta de Seguro por muerte accidental o desmembramiento hasta $10,000.00 a través de Santander Insurance Agency, Inc, libre de costo. Póliza adicional disponible por una cantidad mínima mensual 7 Requisitos Balance de apertura: $0.00 Edad mínima: 21 años Observaciones $0 cargos por servicio mensual 2 Se podrán girar cheques ilimitados y libres de costo si el cliente mantiene un balance promedio cobrado mensual de $5,000 o más. En caso que el cliente mantenga un balance promedio inferior a $5,000, podrá girar hasta 15 cheques mensuales libres de costo y al resto se aplicará un cargo de $0.50 por cada uno en exceso de 15. Intereses acreditados mensualmente a base del balance mensual. Otros cargos por servicio 11, 12, 13, 14, 15\",\n" +
            "creationDate: \"2014-07-08T13:02:20.58Z\",\n" +
            "date: \"2014-07-08T07:00:00Z\",\n" +
            "detailFormat: \"text\",\n" +
            "expirationDate: \"2015-07-08T07:00:00Z\",\n" +
            "id: 6,\n" +
            "isDeleted: false,\n" +
            "listFormat: \"text\",\n" +
            "modifiedDate: \"2014-07-08T13:02:20.58Z\",\n" +
            "moreInformationUrl: \"\",\n" +
            "publishedDate: \"2014-07-08T07:00:00Z\",\n" +
            "subtitle: \"Disfrute todo lo que tiene\",\n" +
            "textColor: \"rgb(18, 28, 48)\",\n" +
            "title: \"Todo Santander\"\n" +
            "},\n" +
            "{\n" +
            "backgroundColor: \"#ff9900\",\n" +
            "body: \"Maneje el rumbo de sus ahorros La cuenta Ahorro Directo es una cuenta de ahorro que gana intereses escalonados. Mientras más alto el balance de su cuenta más alta será la tasa de interés que le aplicamos. La cuenta la puede abrir con solo $100.00. Tiene disponible el servicio de Ahorro Directo que le retira de su cuenta de cheques en cualquier banco mensualmente la cantidad que usted escoja (mínimo de $25.00) para así depositársela en su cuenta Ahorro Directo Santander. Beneficios 1 Banco en Línea gratis, a través de eBanking Tarjeta Santander Express MasterCard (Edad Mínima 21 años) Gratis 2, 3, 5, 15 Tarjeta Santander Express Regular (Edad Mínima 18 años) Gratis 2, 3, 5, 15 Banco en Casa Gratis Puede escoger ahorrar mensualmente de $25.00 en adelante 4 Beneficios Adicionales 3 Pago Express Tasas de interés competitivas Transferencia automática de la cuenta de cheques conforme a la cantidad indicada (Servicio de ahorro directo) 4 No retiros en casos de sobregiros en la cuenta de cheques Servicio de mensajería al celular “Santander Te Llama” 5 Servicio de eStatement Gratis 14 Requisitos Balance de apertura $100.00 Edad mínima 18 años: Tarjeta Santander Express Regular Edad mínima 21 años: Tarjeta Santander Express MasterCard Observaciones Intereses escalonados calculados diariamente a base del balance promedio diario aplicable a cada estrata. Los intereses serán acreditados a su cuenta mensualmente 6, 7 Balance mínimo diario para evitar cargos es de $2,000 o más durante todos los días del mes que comprenda el ciclo. Cargo por servicio mensual para balances diarios menores de $2,000: $5.95 Cargo por cierre de cuenta antes de 90 días: $10.00 Cargo por cada retiro en sucursal en exceso al tercero: $1.00 Retiros ilimitados gratis si el balance promedio diario es de $5,000 o más Cargo por cambiar la cantidad a ahorrar después de la primera vez al año: $1.00 No se cobrará por aumentos en la cantidad a ahorrar Otros cargos 5, 8, 9, 10, 11, 12, 13, 14, 15\",\n" +
            "creationDate: \"2014-07-08T13:36:24.247Z\",\n" +
            "date: \"2014-07-08T07:00:00Z\",\n" +
            "detailFormat: \"text\",\n" +
            "expirationDate: \"2015-07-08T07:00:00Z\",\n" +
            "id: 7,\n" +
            "isDeleted: false,\n" +
            "listFormat: \"text\",\n" +
            "modifiedDate: \"2014-07-08T13:36:24.247Z\",\n" +
            "moreInformationUrl: \"\",\n" +
            "publishedDate: \"2014-07-08T07:00:00Z\",\n" +
            "subtitle: \"\",\n" +
            "textColor: \"#000000\",\n" +
            "title: \"Ahorro Directo\"\n" +
            "},\n" +
            "{\n" +
            "backgroundColor: \"rgb(220, 220, 220)\",\n" +
            "body: \"30% incluyendo un producto CocaCola CONDICIONES Y RESTRICCIONES: EL DESCUENTO APLICA SOLO PARA LOS ALIMENTOS DEL MENÚ Y BEBIDAS DEL PORTAFOLIO DE PRODUCTOS DE THE COCA-COLA COMPANY. La actividad “Lunes Gastronómico” tendrá una vigencia del 4 de agosto al 24 de noviembre de 2014, sin incluir los lunes festivos. Aplica para los restaurantes participantes de las ciudades de Bogotá, La Calera, El Rosal y Cota. Válido únicamente en los restaurantes inscritos a la actividad informados en la páginas web www.cmrdescuentos.com y www.clubpremium.co. Para aplicar el descuento es indispensable: i) realizar la totalidad del pago de la factura con las Tarjetas Débito y Crédito de Banco Falabella S.A. ii) consumir al menos un producto del portafolio de The Coca-Cola Company, en la factura total por persona. El descuento aplica sobre la cuenta incluyendo bebidas del portafolio de productos de The Coca-Cola Company, no aplica en las bebidas alcohólicas, el impuesto al consumo, IVA y servicio (propinas). El beneficio no es reembolsable en dinero. No acumulable con otras promociones o descuentos, ni acumulable entre sí. Las Tarjetas de Banco Falabella S.A. son exclusivamente un medio de pago de los productos y servicios anunciados, por tanto éste no asume responsabilidad alguna sobre los productos o servicios adquiridos por el cliente con el uso de sus tarjetas. Banco Falabella S.A. es una entidad vigilada por la Superintendencia Financiera de Colombia. \",\n" +
            "creationDate: \"2014-09-05T18:28:39.907Z\",\n" +
            "date: \"2014-09-05T07:00:00Z\",\n" +
            "detailFormat: \"textAndImage\",\n" +
            "detailImageId: 62,\n" +
            "expirationDate: \"2014-12-28T08:00:00Z\",\n" +
            "id: 8,\n" +
            "isDeleted: false,\n" +
            "listFormat: \"textAndLeftImage\",\n" +
            "listImageId: 60,\n" +
            "modifiedDate: \"2014-09-05T18:36:31.663Z\",\n" +
            "moreInformationUrl: \"\",\n" +
            "publishedDate: \"2014-09-05T07:00:00Z\",\n" +
            "subtitle: \"30% incluyendo un producto CocaCola\",\n" +
            "textColor: \"rgb(18, 28, 48)\",\n" +
            "title: \"Nick's - Sandwiches y Ensaladas\"\n" +
            "},\n" +
            "{\n" +
            "backgroundColor: \"rgb(220, 220, 220)\",\n" +
            "body: \"\",\n" +
            "creationDate: \"2014-09-05T19:06:50.557Z\",\n" +
            "date: \"2014-09-05T07:00:00Z\",\n" +
            "detailFormat: \"banner\",\n" +
            "detailImageId: 65,\n" +
            "expirationDate: \"2014-12-27T08:00:00Z\",\n" +
            "id: 9,\n" +
            "isDeleted: false,\n" +
            "listFormat: \"textAndLeftImage\",\n" +
            "listImageId: 67,\n" +
            "modifiedDate: \"2014-09-05T19:06:50.557Z\",\n" +
            "moreInformationUrl: \"\",\n" +
            "publishedDate: \"2014-09-05T07:00:00Z\",\n" +
            "subtitle: \"30% incluyendo un producto CocaCola\",\n" +
            "textColor: \"rgb(18, 28, 48)\",\n" +
            "title: \"Serafina - Carnes\"\n" +
            "},\n" +
            "{\n" +
            "backgroundColor: \"rgb(220, 220, 220)\",\n" +
            "body: \"30% incluyendo un producto CocaCola con su Picada CONDICIONES y RESTRICCIONES: EL DESCUENTO APLICA SOLO PARA LOS ALIMENTOS DEL MENÚ Y BEBIDAS DEL PORTAFOLIO DE PRODUCTOS DE THE COCA-COLA COMPANY. La actividad “Lunes Gastronómico” tendrá una vigencia del 4 de agosto al 24 de noviembre de 2014, sin incluir los lunes festivos. Aplica para los restaurantes participantes de las ciudades de Bogotá, La Calera, El Rosal y Cota. Válido únicamente en los restaurantes inscritos a la actividad informados en la páginas web www.cmrdescuentos.com y www.clubpremium.co. Para aplicar el descuento es indispensable: 1) realizar la totalidad del pago de la factura con las Tarjetas Débito y Crédito de Banco Falabella S.A. 2) consumir al menos un producto del portafolio de The Coca-Cola Company, en la factura total por persona. El descuento aplica sobre la cuenta incluyendo bebidas del portafolio de productos de The Coca-Cola Company, no aplica en las bebidas alcohólicas, el impuesto al consumo, IVA y servicio (propinas). El beneficio no es reembolsable en dinero. No acumulable con otras promociones o descuentos, ni acumulable entre sí. Las Tarjetas de Banco Falabella S.A. son exclusivamente un medio de pago de los productos y servicios anunciados, por tanto éste no asume responsabilidad alguna sobre los productos o servicios adquiridos por el cliente con el uso de sus tarjetas. Banco Falabella S.A. es una entidad vigilada por la Superintendencia Financiera de Colombia.\",\n" +
            "creationDate: \"2014-09-05T19:11:43.17Z\",\n" +
            "date: \"2014-09-05T07:00:00Z\",\n" +
            "detailFormat: \"textAndImage\",\n" +
            "detailImageId: 68,\n" +
            "expirationDate: \"2014-12-27T08:00:00Z\",\n" +
            "id: 10,\n" +
            "isDeleted: false,\n" +
            "listFormat: \"textAndLeftImage\",\n" +
            "listImageId: 69,\n" +
            "modifiedDate: \"2014-09-05T19:11:43.17Z\",\n" +
            "moreInformationUrl: \"\",\n" +
            "publishedDate: \"2014-09-05T07:00:00Z\",\n" +
            "subtitle: \"Centro Salitre - 30% Descuentos\",\n" +
            "textColor: \"rgb(18, 28, 48)\",\n" +
            "title: \"Cervecería Irlandesa – Picadas\"\n" +
            "}\n" +
            "],\n" +
            "pointsOfInterest: [\n" +
            "{\n" +
            "address: \"Av. 18 de Julio 999 esq. Julio Herrera y Obes\",\n" +
            "creationDate: \"2014-06-25T18:11:58.703Z\",\n" +
            "email: \"\",\n" +
            "id: 1,\n" +
            "imageId: 36,\n" +
            "isDeleted: false,\n" +
            "latitude: -34.90589,\n" +
            "longitude: -56.1947,\n" +
            "modifiedDate: \"2014-06-25T18:43:06.837Z\",\n" +
            "name: \"71 | Banca Preferencial Van Gogh Centro\",\n" +
            "notes: \"\",\n" +
            "telephone: \"2916 1747\",\n" +
            "type: \"branch\",\n" +
            "workingHours: \"Lunes a Viernes de 13:00 a 17:00 hs.\",\n" +
            "zone: {\n" +
            "zoneId: 10\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "address: \"Br. Artigas 380 esq. Solano García\",\n" +
            "creationDate: \"2014-06-25T18:20:46.437Z\",\n" +
            "email: \"\",\n" +
            "id: 2,\n" +
            "imageId: 37,\n" +
            "isDeleted: false,\n" +
            "latitude: -34.92201,\n" +
            "longitude: -56.16189,\n" +
            "modifiedDate: \"2014-06-25T18:20:46.437Z\",\n" +
            "name: \"70 | Golf\",\n" +
            "notes: \"Red Banred. Otros teléfonos: 2711 9862 - 2711 0893 Fax: 2711 2467\",\n" +
            "telephone: \"2711 6707\",\n" +
            "type: \"branch\",\n" +
            "workingHours: \"Atención al público: 13 - 17 hs. | Horario de buzonera: 09 - 19 hs.\",\n" +
            "zone: {\n" +
            "zoneId: 6\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "address: \"Av. Gral Artigas 568\",\n" +
            "creationDate: \"2014-06-25T18:28:34.53Z\",\n" +
            "email: \"\",\n" +
            "id: 3,\n" +
            "imageId: 38,\n" +
            "isDeleted: false,\n" +
            "latitude: -34.72697,\n" +
            "longitude: -56.21727,\n" +
            "modifiedDate: \"2014-06-25T18:29:20.593Z\",\n" +
            "name: \"34 | Las Piedras\",\n" +
            "notes: \"Red Banred\",\n" +
            "telephone: \"1747\",\n" +
            "type: \"branch\",\n" +
            "workingHours: \"Atención al público: 12:30 a 18:00hs. | Horario de buzonera: 24hs.\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Gral. Artigas 953\",\n" +
            "creationDate: \"2014-06-25T18:35:14.873Z\",\n" +
            "email: \"\",\n" +
            "id: 4,\n" +
            "imageId: 39,\n" +
            "isDeleted: false,\n" +
            "latitude: -34.72633,\n" +
            "longitude: -55.95781,\n" +
            "modifiedDate: \"2014-06-25T18:35:14.873Z\",\n" +
            "name: \"15 | Pando\",\n" +
            "notes: \"Red Banred\",\n" +
            "telephone: \"2292 7176\",\n" +
            "type: \"branch\",\n" +
            "workingHours: \"Atención al público: 13 - 17 hs. | Horario de buzonera: 09 - 19 hs.\"\n" +
            "},\n" +
            "{\n" +
            "address: \"26 de Marzo 3540 esq. Luis Alberto de Herrera\",\n" +
            "creationDate: \"2014-06-25T18:41:06.193Z\",\n" +
            "email: \"\",\n" +
            "id: 5,\n" +
            "imageId: 40,\n" +
            "isDeleted: false,\n" +
            "latitude: -34.9057,\n" +
            "longitude: -56.13618,\n" +
            "modifiedDate: \"2014-06-25T18:41:06.193Z\",\n" +
            "name: \"60 | Puerto del Buceo\",\n" +
            "notes: \"Red Banred\",\n" +
            "telephone: \"2622 6252\",\n" +
            "type: \"branch\",\n" +
            "workingHours: \"Atención al público: 13 - 17 hs. | Horario de buzonera: 24 hs.\",\n" +
            "zone: {\n" +
            "zoneId: 8\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "address: \"Av. Gral. Flores 544\",\n" +
            "creationDate: \"2014-06-25T18:52:13.8Z\",\n" +
            "email: \"\",\n" +
            "id: 6,\n" +
            "imageId: 41,\n" +
            "isDeleted: false,\n" +
            "latitude: -34.46933,\n" +
            "longitude: -57.86403,\n" +
            "modifiedDate: \"2014-06-25T18:52:13.8Z\",\n" +
            "name: \"80 | Banca Preferencial Van Gogh Colonia\",\n" +
            "notes: \"Fax: 4523 0812\",\n" +
            "telephone: \"4523 1571\",\n" +
            "type: \"branch\",\n" +
            "workingHours: \"Atención al público: Lunes a Viernes de 13:00 a 17:00 hs. | Autoservicio: 24 hs.\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Av. Gorlero y 25\",\n" +
            "city: {\n" +
            "cityId: 1,\n" +
            "name: \"Montevideo\"\n" +
            "},\n" +
            "creationDate: \"2014-06-25T19:03:48.577Z\",\n" +
            "email: \"\",\n" +
            "id: 7,\n" +
            "imageId: 42,\n" +
            "isDeleted: false,\n" +
            "latitude: -34.96225,\n" +
            "longitude: -54.94363,\n" +
            "modifiedDate: \"2014-06-25T19:03:48.577Z\",\n" +
            "name: \"79 | Península\",\n" +
            "notes: \"\",\n" +
            "state: {\n" +
            "name: \"Montevideo\",\n" +
            "stateId: 1\n" +
            "},\n" +
            "telephone: \"42444050\",\n" +
            "type: \"branch\",\n" +
            "workingHours: \"Atención al público: 13 - 17 hs. | Horario de Buzonera: 24 hs.\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Recinto Sur Esq. Comercio Local #9 Esq. San Justo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"aap1@santander.pr\",\n" +
            "id: 1463,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.464884,\n" +
            "longitude: -66.112303,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"San Juan\",\n" +
            "telephone: \"787-721-3030\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. De Diego #401 Puerto Nuevo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"mro@bspr.com\",\n" +
            "id: 1464,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.44624,\n" +
            "longitude: -66.068301,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Puerto Nuevo\",\n" +
            "telephone: \"787-782-1385\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Domenech #317 Hato Rey\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"yam@bspr.com\",\n" +
            "id: 1465,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.413638,\n" +
            "longitude: -66.064914,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Domenech\",\n" +
            "telephone: \"787-766-1135\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plazoleta Las Cumbres, Lote #1<br>Ave. Las Cumbres, Carr. P.R. 199 Km 6.7<br>Barrio Santa Rosa\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"hrs@bspr.com\",\n" +
            "id: 1466,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.363731,\n" +
            "longitude: -66.125143,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Guaynabo I\",\n" +
            "telephone: \"787-720-9500\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ponce de León Shopping Center Ave. Esmeralda Esq. Lopategui\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"sculpeper@bspr.com\",\n" +
            "id: 1467,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.371037,\n" +
            "longitude: -66.100233,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Guaynabo II *\",\n" +
            "telephone: \"787-720-7485\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Torrimar Shopping Center 19-22 Ave. Ramirez de Arellano Ste 10\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"mmayol@bspr.com\",\n" +
            "id: 1468,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.390389,\n" +
            "longitude: -66.118378,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Torrimar *\",\n" +
            "telephone: \"787-781-1615\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave Ponce de León #207 Hato Rey\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"drc2@bspr.com\",\n" +
            "id: 1469,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.427049,\n" +
            "longitude: -66.057741,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Ponce de León\",\n" +
            "telephone: \"787-759-7070\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Edif. Instituto San Pablo Hosp. San Pablo Calle Santa Cruz #66\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"privera@bspr.com\",\n" +
            "id: 1470,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.3975,\n" +
            "longitude: -66.148515,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"San Pablo\",\n" +
            "telephone: \"787-798-4038\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Betances y Baldorioty\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"jrp@bspr.com\",\n" +
            "id: 1471,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.234156,\n" +
            "longitude: -66.035396,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Caguas Main\",\n" +
            "telephone: \"787-746-2626\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. 65 Infantería Esq. Calle #13 Ext. San Agustín Rio Piedras\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"ccd@bspr.com\",\n" +
            "id: 1472,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.396306,\n" +
            "longitude: -66.023007,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"65 Infantería\",\n" +
            "telephone: \"787-766-4045\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Gautier Benítez #179 Frente a San Alfonso Shopping Center\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"mcc1@bspr.com\",\n" +
            "id: 1473,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Caguas Sur *\",\n" +
            "telephone: \"787-743-2425\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. San Carlos Esq. Ave. Betances\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"ccd@bspr.com\",\n" +
            "id: 1474,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.429639,\n" +
            "longitude: -67.154939,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Aguadilla *\",\n" +
            "telephone: \"787-891-0344\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza Río Hondo Mall\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"jab@bspr.com\",\n" +
            "id: 1475,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Río Hondo\",\n" +
            "telephone: \"787-795-2828\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza del Mercado Calle De Diego #38 Río Piedras\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"rlh@bspr.com\",\n" +
            "id: 1476,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.398745,\n" +
            "longitude: -66.048324,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Río Piedras\",\n" +
            "telephone: \"787-765-7984\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"525 AV F.D. Roosevelt, Plaza las Américas Mall, Nivel 1, Hato Rey\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"mlc@bspr.com\",\n" +
            "id: 1477,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.423853,\n" +
            "longitude: -66.074368,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Plaza las Américas *\",\n" +
            "telephone: \"787-756-7777\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #130 Km. 4.9 Bo. Naranjito, Sector Lechuga\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"cls@bspr.com\",\n" +
            "id: 1478,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hatillo\",\n" +
            "telephone: \"787-898-0451\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Fajardo Shopping Center Carr. Estatal #3 Km. 44.9\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"asas@bspr.com\",\n" +
            "id: 1479,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.346852,\n" +
            "longitude: -65.672643,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Fajardo\",\n" +
            "telephone: \"787-863-4055\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carretera 1 Km. 57.5 Lote 3 Bo. Montellano\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"jrr2@bspr.com\",\n" +
            "id: 1480,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.116642,\n" +
            "longitude: -66.144441,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Cayey *\",\n" +
            "telephone: \"787-738-5262\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Km. 260.4 Bo. Cañas Urb. Villa Real\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"ffc@bspr.com\",\n" +
            "id: 1481,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Ponce by Pass *\",\n" +
            "telephone: \"787-844-1105\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Esq. Patriota Pozo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"hsb@bspr.com\",\n" +
            "id: 1482,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.429634,\n" +
            "longitude: -66.493359,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Manatí *\",\n" +
            "telephone: \"787-854-2727\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. José De Diego Esquina Castelar #316\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"faa@bspr.com\",\n" +
            "id: 1483,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.472344,\n" +
            "longitude: -66.722546,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Arecibo De Diego *\",\n" +
            "telephone: \"787-878-3636\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Km. 80.4 Bo. San Daniel\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"palicea@bspr.com\",\n" +
            "id: 1484,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Plaza Atlántico Mall\",\n" +
            "telephone: \"787-879-1671\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Dr. Cueto #57A\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"mja@bspr.com\",\n" +
            "id: 1485,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.265849,\n" +
            "longitude: -66.701257,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Utuado\",\n" +
            "telephone: \"787-894-2335\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Lope Hormazabal #43 Urb. Madrid\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"ace@bspr.com\",\n" +
            "id: 1486,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.230737,\n" +
            "longitude: -65.922303,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Juncos\",\n" +
            "telephone: \"787-734-8249\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Palmer #15\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"dnc@bspr.com\",\n" +
            "id: 1487,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.175828,\n" +
            "longitude: -66.161283,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Cidra\",\n" +
            "telephone: \"787-739-8122\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"José M. Toro Basora #10 Esq. Amistad\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"evs@bspr.com\",\n" +
            "id: 1488,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Lajas\",\n" +
            "telephone: \"787-899-4000\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Vilella #6\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"jdg@bspr.com\",\n" +
            "id: 1489,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.2949246,\n" +
            "longitude: -66.8774374,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Lares\",\n" +
            "telephone: \"787-897-3033\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Las AméricasEsq. Hostos\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"jnm@bspr.com\",\n" +
            "id: 1490,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Ponce Las Américas\",\n" +
            "telephone: \"787-840-4447\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza Degetau Esq. Paseo Antonio Arias\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"nbm@bspr.com\",\n" +
            "id: 1491,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.011098,\n" +
            "longitude: -66.613348,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Ponce Plaza\",\n" +
            "telephone: \"787-844-1010\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Palmer Esq. Vicente Palés\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"pfe@bspr.com\",\n" +
            "id: 1492,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Guayama\",\n" +
            "telephone: \"787-864-0914\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Yauco Plaza #121\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"clr1@bspr.com\",\n" +
            "id: 1493,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.025486,\n" +
            "longitude: -66.855543,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Yauco *\",\n" +
            "telephone: \"787-856-0300\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Méndez Vigo #5 Esq. Dr. Basora\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"vcc@bspr.com\",\n" +
            "id: 1494,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.201856,\n" +
            "longitude: -67.140166,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Mayagüez Pueblo\",\n" +
            "telephone: \"787-834-0545\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Ruiz Belvis Esq. Miramar\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"bam@bspr.com\",\n" +
            "id: 1495,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"San Sebastián\",\n" +
            "telephone: \"787-896-1050\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Degetau Esq. Carrión Maduro\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"rny@bspr.com\",\n" +
            "id: 1496,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.053662,\n" +
            "longitude: -66.506325,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Juana Díaz\",\n" +
            "telephone: \"787-837-3030\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Silvestre S. Rodríguez #63 Esquina 25 de Julio\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"amf@bspr.com\",\n" +
            "id: 1497,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Guánica\",\n" +
            "telephone: \"787-821-2283\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr #2\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"yponce@bspr.com\",\n" +
            "id: 1498,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.156006,\n" +
            "longitude: -67.142161,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Mayagüez Mall *\",\n" +
            "telephone: \"787-833-2020\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Luna #191 Urb. El Retiro\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"npm1@bspr.com\",\n" +
            "id: 1499,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.081161,\n" +
            "longitude: -67.040658,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"San Germán\",\n" +
            "telephone: \"787-892-5656\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Barbosa #19 Esq. José A. Vargas\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"rcm3@bspr.com\",\n" +
            "id: 1500,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.500681,\n" +
            "longitude: -67.024066,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Isabela\",\n" +
            "telephone: \"787-872-2050\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ruíz Rivera #22\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"nc1@bspr.com\",\n" +
            "id: 1501,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Cabo Rojo\",\n" +
            "telephone: \"787-851-1700\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Jesús T. Piñero #1421-23 Puerto Nuevo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"vrm1@bspr.com\",\n" +
            "id: 1502,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.402715,\n" +
            "longitude: -66.090043,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Avenida Piñero II\",\n" +
            "telephone: \"787-781-6435\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Kennedy #40 Esq. Carr. 107\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"cqf@bspr.com\",\n" +
            "id: 1503,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Aguadilla II\",\n" +
            "telephone: \"787-891-8282\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"2050 Carr. #2, Ponce Plaza del Caribe Shopping Center Local 173\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"cpc@bspr.com\",\n" +
            "id: 1504,\n" +
            "isDeleted: false,\n" +
            "latitude: 17.993632,\n" +
            "longitude: -66.611652,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Ponce Plaza del Caribe Shopping Center *\",\n" +
            "telephone: \"787-259-2300\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Avenida Los Romeros Local D-10 Río Piedras\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"cms@bspr.com\",\n" +
            "id: 1505,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.339118,\n" +
            "longitude: -66.067786,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Montehiedra Town Center *\",\n" +
            "telephone: \"787-287-3131\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Palma Real Mall Carr. #3\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"frc@bspr.com\",\n" +
            "id: 1506,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.142151,\n" +
            "longitude: -65.809264,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Plaza Palma Real Humacao *\",\n" +
            "telephone: \"787-285-0333\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Bayamón Oeste Shopping Center Carr. #2 Km. 14.7\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"mbb@bspr.com\",\n" +
            "id: 1507,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.408034,\n" +
            "longitude: -66.186485,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Bayamón Oeste *\",\n" +
            "telephone: \"787-780-1101\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Cantón Mall Shopping Center Calle Betances #40\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"rdg@bspr.com\",\n" +
            "id: 1508,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Cantón Mall\",\n" +
            "telephone: \"787-785-9801\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Lomas Verdes #1-A-1\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"acp@bspr.com\",\n" +
            "id: 1509,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.382654,\n" +
            "longitude: -66.144792,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Lomas Verdes\",\n" +
            "telephone: \"787-785-4415\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Ponce de León #1225 Edificio Caso Pda. 18 Santurce\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"nps1@bspr.com\",\n" +
            "id: 1510,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Santurce\",\n" +
            "telephone: \"787-721-3555\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Km. 37.2 Bo. Caribe Esq. Carr. Estatal #688\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"jog@bspr.com\",\n" +
            "id: 1511,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.445746,\n" +
            "longitude: -66.377968,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Vega Baja\",\n" +
            "telephone: \"787-858-2475\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Jesús M. Fragoso, Plaza Carolina Mall Nivel 2\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"jrac@bspr.com\",\n" +
            "id: 1512,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.39283,\n" +
            "longitude: -65.974853,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Plaza Carolina *\",\n" +
            "telephone: \"787-752-7676\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Centro Comercial Los Dominicos Ave. Boulevard\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"oab@bspr.com\",\n" +
            "id: 1513,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.444722,\n" +
            "longitude: -66.175556,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Levittown\",\n" +
            "telephone: \"787-784-6665\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Barceló # 60 Esq. Padre Dávila\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"jalejandro@bspr.com\",\n" +
            "id: 1514,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.18618,\n" +
            "longitude: -66.305105,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Barranquitas\",\n" +
            "telephone: \"787-857-2355\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Barbosa Esq. Calle América #394 Hato Rey\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"nms@bspr.com\",\n" +
            "id: 1515,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.419069,\n" +
            "longitude: -66.043925,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Barbosa\",\n" +
            "telephone: \"787-763-1895\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Loíza #1608 Esq. Calle San Jorge Santurce\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"fcr@bspr.com\",\n" +
            "id: 1516,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.451695,\n" +
            "longitude: -66.06192,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Calle Loíza *\",\n" +
            "telephone: \"787-728-2240\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Esq. Carr. #167\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"lmn1@bspr.com\",\n" +
            "id: 1517,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.395685,\n" +
            "longitude: -66.157833,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Bayamón Center\",\n" +
            "telephone: \"787-288-6000\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Dorado del Mar Shopping Center\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"ppg@bspr.com\",\n" +
            "id: 1518,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.462735,\n" +
            "longitude: -66.271116,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Dorado *\",\n" +
            "telephone: \"787-796-3435\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Cervantes #6\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"lmc2@bspr.com\",\n" +
            "id: 1519,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.34098,\n" +
            "longitude: -66.317184,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Corozal\",\n" +
            "telephone: \"787-859-2400\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"501 Ave. West Main Sierra, Centro Com. Plaza del Sol\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"mtoro@bspr.com\",\n" +
            "id: 1520,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.407367,\n" +
            "longitude: -66.163208,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Plaza del Sol II *\",\n" +
            "telephone: \"787-778-2525\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Parada 37 1/2 Ave. Ponce de León Hato Rey\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"lsf@bspr.com\",\n" +
            "id: 1521,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Auxilio Mutuo\",\n" +
            "telephone: \"787-296-1601\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Ashford 1451 Esq. Calle Narim Suite 111\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"aap1@bspr.com\",\n" +
            "id: 1522,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Ashford Presbyterian Community Hospital\",\n" +
            "telephone: \"787-977-2510\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carretera Estatal #187 Ave. Isla Verde Solar #9\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"jrac@bspr.com\",\n" +
            "id: 1523,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.441553,\n" +
            "longitude: -66.014861,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Isla Verde\",\n" +
            "telephone: \"787-982-5300\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Albizu Campos Calle José A. Torres\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"pfe@bspr.com\",\n" +
            "id: 1524,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"La Fuente Town Center *\",\n" +
            "telephone: \"787-866-5100\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza Santa Isabel, Carr. 153 KM 7.8\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1525,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.016181,\n" +
            "longitude: -66.381369,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Santa Isabel *\",\n" +
            "telephone: \"787-845-0105\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Centro Comercial Parque Escorial, Ave. 65 Infantería, Río Piedras Barrio San Antón\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"kor@bspr.com\",\n" +
            "id: 1526,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.395497,\n" +
            "longitude: -65.997276,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Parque Escorial I *\",\n" +
            "telephone: \"787-276-4450\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Tabonuco B4, Local #8 Santander Tower, San Patricio\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"mmayol@bspr.com\",\n" +
            "id: 1527,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.406367,\n" +
            "longitude: -66.106493,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"San Patricio\",\n" +
            "telephone: \"787-793-7510\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Lote # 9 Urbanización Industrial Palmas\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1528,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Cataño\",\n" +
            "telephone: \"787-788-8700\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Ponce de León Esq. Ave. Universidad #3\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"angela.diaz@bspr.com\",\n" +
            "id: 1529,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.402954,\n" +
            "longitude: -66.052101,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Plaza Universitaria\",\n" +
            "telephone: \"787-625-8205\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"The Outlet Ruta 66, Carretera #3\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1530,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.376886,\n" +
            "longitude: -65.883014,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Ruta 66\",\n" +
            "telephone: \"787-256-6970\",\n" +
            "type: \"branch\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. San Carlos, Esq. Betances\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1531,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.429639,\n" +
            "longitude: -67.154939,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Aguadilla\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Kennedy #40, Carr. 107\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1532,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.258045,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Aguadilla II\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. de Diego #316\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1533,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.472344,\n" +
            "longitude: -66.722546,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Arecibo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza Atlántico Shopping Mall, Carr. #2\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1534,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.278047,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Plaza Atlántico\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Rotario, Pasillo Principal\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1535,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.46956,\n" +
            "longitude: -66.723779,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Centro Judicial de Arecibo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Barceló #60, Esq. Padre Dávila\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1536,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.18618,\n" +
            "longitude: -66.305105,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Barranquitas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 2 Esq. 167, Bayamón Center Building\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1537,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.395685,\n" +
            "longitude: -66.157833,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Bayamón Center\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza del Parque 1500, Ave. Comerio\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1538,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sam's Club Bayamón\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Comerio Esq. Main Oeste, Sierra Bayamón\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1539,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera Texaco\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Bayamón Oeste Shopping Center\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1540,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.407939,\n" +
            "longitude: -66.186464,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Bayamón Oeste\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Cantón Mall, Calle Betances #40\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1541,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.400017,\n" +
            "longitude: -66.157147,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Cantón Mall\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Lomas Verdes 1A-1\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1542,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.382764,\n" +
            "longitude: -66.144754,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Lomas Verdes\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza Río Hondo Mall\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1543,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Río Hondo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Hospital San Pablo, Ave. Santa Cruz #66\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1544,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.3975,\n" +
            "longitude: -66.148515,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal San Pablo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Marginal Carr. 167, Km. 2.0, Sector La Aldea\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1545,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera Esso\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Km. 4, Centro Judicial Bayamón\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1546,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.392751,\n" +
            "longitude: -66.149248,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Centro Judicial Bayamón\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Main Oeste, Centro Comercial Plaza del Sol\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1547,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.407152,\n" +
            "longitude: -66.162829,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Plaza del Sol (1)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Main Oeste, Esq. Ave. Comerio\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1548,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Walmart Plaza del Sol\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Sector Industrial Luchetti, Carr. #28, Km. 21.1\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1549,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.394095,\n" +
            "longitude: -66.147379,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera Gel Bayamón\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Ruiz Rivera #22\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1550,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.089679,\n" +
            "longitude: -67.145237,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Cabo Rojo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Betances, Esq. Baldorioty\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1551,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.234156,\n" +
            "longitude: -66.035396,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Caguas Main\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Gautier Benítez #179\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1552,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.2312949,\n" +
            "longitude: -66.0352039,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Caguas Sur (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr #189 Km 3.3 Caguas P.R. 00725\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1553,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad del Turabo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Rafael Cordero, Esq. José Villares Rodríguez\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1554,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.22919,\n" +
            "longitude: -66.035782,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Centro Judicial Caguas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Sam's Plaza Centro Ave. Luis Muñoz Marín\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1555,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sam's Club Caguas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza Carolina Mall, Nivel 2\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1556,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.39283,\n" +
            "longitude: -65.974853,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Plaza Carolina (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Sam's Club, Parque Escorial, Ave. 65 Inf.\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1557,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sam's Club Parque Escorial\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Walmart, Parque Escorial, Ave. 65 Inf.\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1558,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Walmart Parque Escorial\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. 65 Infantería, Urb. Lomas de Carolina\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1559,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.3807819,\n" +
            "longitude: -65.9573872,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Centro Judicial Carolina\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Centro Comercial Plaza Escorial Ave. 65 Infantería\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1560,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.395497,\n" +
            "longitude: -65.997276,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Parque Escorial (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Campo Rico Este,Esquina Expreso Baldorioty de Castro\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1561,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Colegio Universitario del Este\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Isla Verde # 1313\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1562,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.441553,\n" +
            "longitude: -66.014861,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Isla Verde\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Orchado, Esq. Núñez Romeu #101\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1563,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.116642,\n" +
            "longitude: -66.144441,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Cayey\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Supermercado Grande Carr. 1,Km. 48.7 Bo. Montellano\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1564,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Supermercado Grande\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Palmer #15\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1565,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.175828,\n" +
            "longitude: -66.161283,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Cidra\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Cervantes #6\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1566,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.34098,\n" +
            "longitude: -66.317184,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Corozal\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Hotel Hyatt Cerromar, Carr # 693 KM 12.7\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1567,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hotel Hyatt Cerromar (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Hotel Hyatt Dorado Beach, Carr # 693 KM 11.8\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1568,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hotel Hyatt Dorado Beach\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Centro Comercial Paseos del PlazaCarr. Estatal #696 Int. Ave. Higuillar, Bo. Higuillar\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1569,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Supermercado Amigo Dorado\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Dorado del Mar Shopping Center\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1570,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.462735,\n" +
            "longitude: -66.271116,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Dorado\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 3 Km. 44.9\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1571,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.346852,\n" +
            "longitude: -65.672643,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Fajardo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #3, Km. 43.3, Int. Carr. 194\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1572,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Walmart Fajardo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Silvestre S. Rodríguez #63Esq. 25 de Julio\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1573,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Guanica\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Palmer, Esq. Vicente Palés\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1574,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Guayama\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Albizu Campos, Calle José Torres\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1575,\n" +
            "isDeleted: false,\n" +
            "latitude: 17.9841328,\n" +
            "longitude: -66.1137767,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Guayama Town Center (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Los Veteranos, Km. 134.7\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1576,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Walmart Guayama\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Centro Comercial San Patricio, segundo nivel\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1577,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.3574502,\n" +
            "longitude: -66.1109998,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"San Patricio Food Court\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Las Cumbres, Carr. P.R. 199 Km 6.7, Barrio Santa Rosa\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1578,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.363731,\n" +
            "longitude: -66.125143,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Guaynabo I (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Esmeralda, Ponce de León Shopping Center\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1579,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.371037,\n" +
            "longitude: -66.100233,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Guaynabo II\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Torrimar Shopping Center, Ave. Ramírez Arellano\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1580,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.390389,\n" +
            "longitude: -66.118378,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Torrimar (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Segundo nivel Centro Comercial San Patricio\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1581,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal San Patricio\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 837, Km. 0.8 Bo. Sta. Rosa\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1582,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera Total Guaynabo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 2, Centro Comercial Plaza del Norte\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1583,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Walmart Hatillo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 30, Km. 4.9 Bo. NaranjitoSector Lechuga\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1584,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Hatillo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. # 2, KM. 87.1\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1585,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hatillo Kash and Carry\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Avenida Barbosa, Esq. América #394\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1586,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.419069,\n" +
            "longitude: -66.043925,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Barbosa\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Domenech #317\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1587,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.413642,\n" +
            "longitude: -66.06514,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Domenech\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Primer nivel Plaza Las Américas\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1588,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.423853,\n" +
            "longitude: -66.074368,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Plaza Las Américas (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Ponce de León 207, Hato Rey (2)\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1589,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.427049,\n" +
            "longitude: -66.057741,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Ponce de León (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Muñoz Rivera, Esq. Calle Mayaguez\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1590,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Centro Judicial Hato Rey\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Arterial Hostos, Esq. Calle 2,Nuevo Centro San Juan\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1591,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.427319,\n" +
            "longitude: -66.063806,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Centro Operaciones BSPR\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Cesar Gonzalez, Esq. Calaf\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1592,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Departamento de Educación\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Ponce de León # 221\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1593,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Banco Santander Torre II\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Ponce de León Pda. 171/2\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1594,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Auxilio Mutuo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Edif. AEELA, Ave. Ponce de León #435\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1595,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.4188309,\n" +
            "longitude: -66.0560817,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Edificio Asociación de Empleados del ELA\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 3, Palma Real Mall\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1596,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.142151,\n" +
            "longitude: -65.809264,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Palma Real\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 3 Km. 82.0, Bo. Junquito\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1597,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sam's Club Humacao Plaza\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 3, Walmart Palma RealCarr. 3, Km.78.0 Bo. Río Abajo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1598,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Walmart Palma Real II\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 2, Centro Comercial Plaza Isabela\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1599,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Wal-Mart Isabela\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Barbosa #19, Esq. José A. Vargas\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1600,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.500681,\n" +
            "longitude: -67.024066,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Isabela\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Lope Hormazabal 43, Urb. Madrid\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1601,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.230737,\n" +
            "longitude: -65.922303,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Juncos\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Degetau y Carrión\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1602,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.053662,\n" +
            "longitude: -66.506325,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Juana Díaz\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Jose M del Toro Basora #10 Lajas P.R. 00667\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1603,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Lajas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Vilella #6\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1604,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.2949246,\n" +
            "longitude: -66.8774374,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Lares\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 3, Km. 36.2, Urb. Brisas del Mar\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1605,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Garage Esso Brisas del Mar\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 2, Esq. Patriota Pozo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1606,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.429634,\n" +
            "longitude: -66.493359,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Manatí\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 2, Km 46.2 Urb. Vista Atenas\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1607,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera ESSO\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza Mónaco, Carr. 149 Km. 3 Int. 668\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1608,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Super Max Manatí\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 2, Mayagüez Mall\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1609,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.156006,\n" +
            "longitude: -67.142161,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Mayagüez Mall\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Méndez Vigo, Esq. Dr. Barbosa\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1610,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.201856,\n" +
            "longitude: -67.140166,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Mayagüez Pueblo (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 2, Walmart Mayagüez Mall\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1611,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Walmart Mayagüez Mall\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ponce by Pass, Carr. #2 Km. 260.4, Urb. Valle Real\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1612,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Ponce by Pass\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Las Américas, Esq. Hostos\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1613,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Ponce Las Américas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza del Caribe Mall, Primer nivel\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1614,\n" +
            "isDeleted: false,\n" +
            "latitude: 17.993632,\n" +
            "longitude: -66.611652,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Plaza del Caribe Mall\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Hotel Ponce Hilton, Sector La Guancha\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1615,\n" +
            "isDeleted: false,\n" +
            "latitude: 17.971493,\n" +
            "longitude: -66.602474,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hotel Ponce Hilton\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Intersección PR-2 & PR-52 Baramaya Ave. - Sector Canas\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1616,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Walmart\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 2, Int. Carr. 585\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1617,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sam's Club Ponce\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Santiago de los Caballeros\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1618,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Centro Judicial de Ponce\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Guadalupe Final\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1619,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hospital San Lucas Episcopal\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Degetau, Esq. Paseo Antonio Arias\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1620,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.011098,\n" +
            "longitude: -66.613348,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Ponce Plaza\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. De Diego #401\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1621,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Puerto Nuevo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Piñero #1421\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1622,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.402715,\n" +
            "longitude: -66.090043,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Piñero\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Piñero # 1012\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1623,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolineras Citgo Ave. Piñero\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #3 Km. 28.0 Rio Grande States\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1624,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Supermercado Amigo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 1 Km. 17.3 Alto Apolo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1625,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.384055,\n" +
            "longitude: -66.079244,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Edificio Cruz Azul de P.R.\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Montehiedra Town Center\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1626,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.339118,\n" +
            "longitude: -66.067786,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Montehiedra Food Court\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. 65 de Infantería Esq. Calle 13 Ext. San Agustín\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1627,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.396306,\n" +
            "longitude: -66.023007,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal 65 Infantería\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle De Diego #38\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1628,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.398745,\n" +
            "longitude: -66.048324,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Río Piedras\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. De Diego #948, Urb. La Riviera\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1629,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Esso La Riviera\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Montehiedra Town Center\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1630,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.339501,\n" +
            "longitude: -66.068406,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Montehiedra (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Int. Carr. #849 y Carr. #175 Cupey Bajo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1631,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Supermercado Amigo Cupey\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Las Cumbres Esq. Gran Bulevar,Galería Los Paseos\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1632,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Supermercado Amigo Paseos\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 176 Km 3.0 Ave. Ana G. Méndez\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1633,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad Metropolitana\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Luna #191, Urb. El Retiro\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1634,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.081161,\n" +
            "longitude: -67.040658,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal San Germán\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Ponce de León, Pda 5 1/2\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1635,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Garage Esso Puerta de Tierra\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Recinto Sur #251, Esq. San Justo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1636,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.464936,\n" +
            "longitude: -66.112095,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal San Juan\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Ruiz Belvis, Esq. Miramar\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1637,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal San Sebastián\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Loíza Esq. San Jorge\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1638,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.451695,\n" +
            "longitude: -66.06192,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Calle Loíza 2\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Galería Ashford, Ave. Ashford 1451, Esq. Calle Narim Suite 111\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1639,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Ashford\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Ponce de León 1225 Edif. Caso Pda. 18\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1640,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Santurce\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Fernandez Juncos #1706,Parada 24½\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1641,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolineras Total Santurce\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carretera 159 KM. 20.2, Plaza Aquarium Shopping Center, Bo. Quebrada Cruz\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1642,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Supermercados Amigo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Los Dominicos Shopping Center, Ave. Boulevard\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1643,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.445553,\n" +
            "longitude: -66.175693,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Levittown\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Los Dominicos Shopping Center, Ave. Boulevard\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1644,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolineras Total Levittown\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #865 Km 0.02 Bo. Campanilla\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1645,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"American Gas Toa Baja\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #111 Int. 611\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1646,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.269023,\n" +
            "longitude: -66.696947,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Centro Judicial Utuado\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Dr. Cueto #57\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1647,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.265849,\n" +
            "longitude: -66.701257,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Utuado\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 2, Km. 30.5\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1648,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Garaje Esso Vega Alta\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 2 Km. 37.2 Bo. Cabo Caribe Esq Carr. Estatal #688\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1649,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.445746,\n" +
            "longitude: -66.377968,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Vega Baja (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Yauco Plaza Shopping, Local #121\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1650,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.025486,\n" +
            "longitude: -66.855543,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Yauco Plaza (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 506 Km. 1 Hm. 0 Bo. Cotto Laurel\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1651,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera Shell Cotto Laurel\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 325 Barrio Salinas Providencia, Ensenada\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1652,\n" +
            "isDeleted: false,\n" +
            "latitude: 17.9678755,\n" +
            "longitude: -66.9302976,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Centro Vacacional AEELA\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Unión-Batey Central Carr. 195\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1653,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.34023,\n" +
            "longitude: -65.640899,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad Interamericana - Recinto Fajardo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 1 Km. 16.3 Esq. Calle San Francisco Sein\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1654,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.401165,\n" +
            "longitude: -66.049778,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad Inter Metro\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Gautier Benítez #179 (Peatonal)\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1655,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Caguas Sur\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 830 #500 Bo. Cerro Gordo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1656,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.3616667,\n" +
            "longitude: -66.1730556,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad Interamericana - Recinto Bayamón\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Bo. Machete, Carr. 744 KM 1.2\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1657,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad Interamericana Recinto Guayama\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #3 interseccion #1 Barrio Coco Beach, Rio Grande PR 00745\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1658,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hotel Paradisus en Rio Grande\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Km 87.7 interseccion Carr. 130, Hatillo PR 00659\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1659,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Supermercado Amigo de Hatillo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #102 Km. 30.6\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1660,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.083548,\n" +
            "longitude: -67.050789,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad Interamericana - Recinto de San Germán\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Urb. Industrial Reparada, Ponce By Pass\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1661,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hermanos Santiago Cash & Carry\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"2325 Ave. Las Américas\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1662,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.001703,\n" +
            "longitude: -66.61736,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad Católica de Ponce\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #887 Bo. San Antón\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1663,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.3875,\n" +
            "longitude: -65.9930556,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad de PR - Recinto de Carolina\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Antonio R. Barceló, Cayey PR\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1664,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad de PR Recinto de Cayey\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Hotel Caribe Hilton, Calle Los Rosales (Frente Valet Parking)\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1665,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.463617,\n" +
            "longitude: -66.085795,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hotel Caribe Hilton\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Área Centro Médico de PR.\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1666,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.3944687,\n" +
            "longitude: -66.0731371,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Edificio Principal, Recinto de Ciencias Médicas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Urbanización La Milagrosa, Calle Zalla-Verde, Bayamón PR\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1667,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad Central de Bayamón\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza Santa Isabel, Carr. 153 KM 7.8\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1668,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.016181,\n" +
            "longitude: -66.381369,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Santa Isabel (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"998 Calle San Roberto\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1669,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Edificio Banco Santander / Island Finance\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Pedro Albizu Campos Carr PR 180 Km 0 Hm 2 Bo. Pueblo Nuevo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1670,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Supermercado Amigo Salinas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 3, Km 155.2, Bo. Jaguas\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1671,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Texaco Salinas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Roosevelt Esq. Calle América Urb. Piñero\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1672,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Supermercado Econo Facundo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Roosevelt #1441\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1673,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.413562,\n" +
            "longitude: -66.096427,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Edificio Triple S\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 3 Km 8.3 Ave. 65 de Infantería\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1674,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hospital UPR\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"#80 Road 3341 Suite 102 Port of Mayagüez\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1675,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Puerto Mayagüez – Holland Group\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Km. 15.9 Bo. Candelaria\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1676,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera Gel Toa Baja\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Roosevelt #1510 Caparra Height\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1677,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Edificio Plaza Triple S\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. # 5 Bo Amelia\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1678,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera Gel\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Pedro Albizu Campos, Urb La Hacienda\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1679,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hospital Cristo Redentor\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Boulevard Alfonso Valdez #259\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1680,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad de PR - Recinto Mayagüez\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle José de Diego, Esq. Palmer\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1681,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.113407,\n" +
            "longitude: -66.165885,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Island Finance\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Sánchez Osorio Local #2 Villa Fontana\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1682,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.404392,\n" +
            "longitude: -65.9734986,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Island Finance\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Villa #339 Esq. Cementerio Civil\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1683,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Toral Ponce\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Villa Fontana Ave. Sánchez Osorio Local #2\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1684,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Island Finance\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr # 19 Km. 1.0 Urb. Altamira\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1685,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Toral Altamira\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Km\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1686,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gulf Caparra\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr #159 KM 15.2 Bo. Pueblo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1687,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gel Corozal\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. # 167 KM 11.0 Bo. Dajaos\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1688,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gel Dajaos\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"PR #3 Km 17.8 Intersección PR66\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1689,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Walmart\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 107 Km. 3.0, Bo. Borinquen\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1690,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Toral Aguadilla\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr # 112 KM 2.4 Bo. Guerrero\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1691,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Toral Isabela\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2, Km. 12.1, Ind. Correa\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1692,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Toral Reparto Correa\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr #2 Km 14.2 Hato Tejas\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1693,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gulf Hato Tejas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr #3 Km 153.3\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1694,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gel Salinas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"103 Calle Muñoz Rivera\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1695,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Island Finance Peñuelas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Km. 65.7 Bo. Factor\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1696,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.442446,\n" +
            "longitude: -66.6348996,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera Gel Arecibo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Km. 28.3 Bo. Espinosa\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1697,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera Gel Vega Alta\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #189 Km. 2.3\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1698,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"GULF Caguas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 775, Km 0.4 Bo. Piñas\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1699,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Toral Comerio\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Plaza Salcedo Carr. 109 Km. 2.5\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1700,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Island Finance Añasco\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Post Int. Calle 4 Hermanos Bo Sábalos\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1701,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"American Gas Mayagüez\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #695 Reparto Doraville\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1702,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.4399466,\n" +
            "longitude: -66.2801686,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"American Gas Dorado\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Muñoz Rivera Esq. Calle Colón\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1703,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"American Gas Vega Alta (Pueblo)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"10 Baldorioty\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1704,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Island Finance\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"178 Calle Colón\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1705,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Island Finance\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"16 Calle Saturnino\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1706,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Island Finance\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"6165 Ave. Isla Verde\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1707,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"ESJ Tower\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #690 Km 1.3 Bo. Sabana Hoyos Lote 4\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1708,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"American Gas Vega Alta (Sabana Hoyos)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"6165 Ave. Isla Verde\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1709,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"ESJ Tower\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr 690 Km. 1.3 Bo Sabana Hoyos Lote 4\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1710,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"American Gas Vega Alta (Sabana Hoyos)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Valle Real Shopping Center Local #5\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1711,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Island Finance Ponce Valle Real\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave Lomas Verdes Esq. Nogal 1\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1712,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Island Finance Bayamón Lomas Verdes\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"207 Los Patriotas\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1713,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.2937255,\n" +
            "longitude: -66.8833588,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Island Finance Lares\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Ponce De León Esq. Ave. Universidad Local #3\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1714,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.402954,\n" +
            "longitude: -66.052101,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Plaza Universitaria\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Tapia #300 Int. Gilberto Monroig\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1715,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Súper Ahorros Villa Palmeras\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Luis Muñoz Rivera #7B\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1716,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Super Ahorros Villaba\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 Km. 157\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1717,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.200291,\n" +
            "longitude: -67.139629,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Edificio Santander Securities Plaza\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Ponce de León #1590, Urb. Caribe\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1718,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.380634,\n" +
            "longitude: -66.0685521,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"GM Plaza Building\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #167 Km. 11.0 Bo. Dajaos\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1719,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.2906065,\n" +
            "longitude: -66.2117066,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera Gel Dajaos\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 3 167 km. 11.0 Bo. Dajaos Bayamón P.R. 00956\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1720,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Gasolinera Gel Dajaos\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #2 km 56.8 Bo. Florida\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1721,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sams Barceloneta\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Ramón E. Betances\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1722,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.20316,\n" +
            "longitude: -67.141196,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hospital San Antonio\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Andres Arus Rivera #32\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1723,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Panadería Kasabe\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Francisco Mariano Quiñones #16\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1724,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.078483,\n" +
            "longitude: -66.962744,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Farmacia Nelia\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #127 Km 8.6 Salida 205\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1725,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.0191314,\n" +
            "longitude: -66.791842,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hotel Pichis Convention Center (Casino)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. El Malecón, La Guancha\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1726,\n" +
            "isDeleted: false,\n" +
            "latitude: 17.9649057,\n" +
            "longitude: -66.6113195,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hermanos Santiago Cash & Carry La Guancha\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"2701 Ave Hostos\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1727,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.236765,\n" +
            "longitude: -67.161409,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Mayagüez Holiday Inn (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"2701 Ave Hostos\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1728,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.236765,\n" +
            "longitude: -67.161409,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Mayagüez Holiday INN Casino\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"3315 Ponce by Pass\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1729,\n" +
            "isDeleted: false,\n" +
            "latitude: 17.979723,\n" +
            "longitude: -66.665254,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Ponce Holiday Inn (2)\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"3315 Ponce By pass\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1730,\n" +
            "isDeleted: false,\n" +
            "latitude: 17.979723,\n" +
            "longitude: -66.665254,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Ponce Holiday INN Casino\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Arterial Hostos, Esq. Calle 2\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1731,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.427156,\n" +
            "longitude: -66.063956,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"ATM Centro Cómputos I\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Arterial Hostos, Esq. Calle 2, Nuevo Centro\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1732,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.427319,\n" +
            "longitude: -66.063806,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"ATM Centro Cómputos II\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #111 Km. 3.9\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1733,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.380442,\n" +
            "longitude: -67.090947,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Chelos Gas Station\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Urb. Frontera Carr. 167, Rio Hondo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1734,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.42957,\n" +
            "longitude: 66.165928,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Plaza Pradera Shopping Center\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. #3 KM. 80.2 Rio Abajo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1735,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Texaco Gas Service Station\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. Estatal #3 Km. 18.4\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1736,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.376886,\n" +
            "longitude: -65.883014,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Ruta 66 Food Court\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 887 KM 2.3 Bo. San Antón\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1737,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Texaco Gas Station\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. 129 KM 9.1 Bo. Campo Alegre\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1738,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.198044,\n" +
            "longitude: -66.502991,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Supermercado Campo Alegre\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"154 Calle San Sebastián\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1739,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.467489,\n" +
            "longitude: -66.116745,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"La Sombrilla Rosa\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"C. Tanca 151, Esq. San Francisco, Viejo San Juan\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1740,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.466079,\n" +
            "longitude: -66.1128982,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Universidad Carlos Albizu\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Centro Médico, Rio Piedras\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1741,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.3915216,\n" +
            "longitude: -66.0748941,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"CFSE Hospital Industrial\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. Estatal # 21, Ave de Diego, La Riviera, Rio Piedras\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1742,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.401165,\n" +
            "longitude: -66.049778,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"CFSE Oficina Central\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. Estatal # 2, Km 126.4 Aguadilla PR (Frente al Parque de las Cascadas)\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1743,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.43264,\n" +
            "longitude: -67.153511,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"CFSE Región Aguadilla\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Miramar, Carr. Estatal # 2, Km 78.7\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1744,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.472945,\n" +
            "longitude: -66.742379,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"CFSE Región Arecibo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. Estatal # 2, Km 8.5 Bo. Juan Sánchez\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1745,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.394095,\n" +
            "longitude: -66.147379,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"CFSE Región Bayamón\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Edif. Mercantil Caguax, Ave. Luis Muñoz Marin Urb Villa Blanca (Contiguo a Santa Juana)\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1746,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.22919,\n" +
            "longitude: -66.035782,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"CFSE Región Caguas\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. San Antón, Sector Comunidad Escorial Carr. PR-3, 65th Infantería\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1747,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.388185,\n" +
            "longitude: -65.988167,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"CFSE Región Carolina\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Boulevard del Rio # 2, Carr. Estatal # 3\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1748,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.15147,\n" +
            "longitude: -65.823374,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"CFSE Región Humacao\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. Estatal # 1 , Esq. Ave. Malecon\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1749,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.0055246,\n" +
            "longitude: -66.6046634,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"CFSE Región Ponce\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Los Corazones, Villa Sultanita, Carr. #2, Bo Sabalo\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1750,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.200291,\n" +
            "longitude: -67.139629,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"CFSE Región Mayagüez\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. # 838, Km 6.3, Sector El 5, Rio Piedras\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1751,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.111573,\n" +
            "longitude: -66.222738,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"CFSE Región San Juan\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Centro Comercial Los Gallegos, Ave. Central Boulevard 3ra Extensión\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1752,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.398092,\n" +
            "longitude: -65.950264,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Econo Villa Carolina\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Centro Comercial Villas de Río Grande, Calle Pimentel #99\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1753,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.3803941,\n" +
            "longitude: -65.8308294,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Island Finance\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle de Diego 38\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1754,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.398658,\n" +
            "longitude: -66.050947,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Plaza del Mercado Río Piedras\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Aeropuerto Luis Muñoz Marín (SJU), Terminal A\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1755,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.436729,\n" +
            "longitude: -66.009239,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Aeropuerto Luis Muñoz Marín, Terminal JetBlue\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Carr. Estatal #3 Km. 18.4 Suite 20\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1756,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.375482,\n" +
            "longitude: -65.904409,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal Ruta 66\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Calle Tabonuco B4, San Patricio Tower\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1757,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.366724,\n" +
            "longitude: -66.117555,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Sucursal San Patricio\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Ave. Gautier Benítez Km 35.7\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1758,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.22162246,\n" +
            "longitude: -66.03988647,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Consolidated Mall\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"122 Carretera #2\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1759,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.432904,\n" +
            "longitude: -66.476694,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Hyatt Place Manatí\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Aeropuerto Luis Muñoz Marín (SJU), Terminal D\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "email: \"\",\n" +
            "id: 1760,\n" +
            "imageId: 41,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.439968,\n" +
            "longitude: -66.004167,\n" +
            "modifiedDate: \"2014-07-16T20:22:51.25Z\",\n" +
            "name: \"Aeropuerto Luis Muñoz Marín\",\n" +
            "notes: \"\",\n" +
            "telephone: \"\",\n" +
            "type: \"atm\",\n" +
            "workingHours: \"\"\n" +
            "},\n" +
            "{\n" +
            "address: \"calle Baldorioty Esq. Willie Rosario #5\",\n" +
            "creationDate: \"2014-07-04T16:00:00Z\",\n" +
            "id: 1761,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.0807773,\n" +
            "longitude: -66.3590777,\n" +
            "modifiedDate: \"2014-07-04T16:00:00Z\",\n" +
            "name: \"Island Finance de Coamo\",\n" +
            "type: \"atm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Av. Ashford esquina Av. de Diego\",\n" +
            "creationDate: \"2014-07-08T14:33:16.187Z\",\n" +
            "email: \"santander@gmail.com\",\n" +
            "id: 1762,\n" +
            "imageId: 42,\n" +
            "isDeleted: false,\n" +
            "latitude: 18.454447,\n" +
            "longitude: -66.062856,\n" +
            "modifiedDate: \"2014-07-08T14:33:16.187Z\",\n" +
            "name: \"Sucursal Condado\",\n" +
            "notes: \"Esta sucursal tiene un horario de atención particular para nuestro cliente vip\",\n" +
            "telephone: \"001 787 2798\",\n" +
            "type: \"branch\",\n" +
            "workingHours: \"De 1 a 2 A.M.\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Libertador 1000\",\n" +
            "creationDate: \"2014-08-04T18:36:51.957Z\",\n" +
            "email: \"\",\n" +
            "id: 1763,\n" +
            "isDeleted: false,\n" +
            "latitude: -34.897094,\n" +
            "longitude: -56.189747,\n" +
            "modifiedDate: \"2014-08-04T18:36:51.957Z\",\n" +
            "name: \"Cajero Libertador\",\n" +
            "notes: \"\",\n" +
            "telephone: \"29291010\",\n" +
            "type: \"atm\",\n" +
            "workingHours: \"08.00 a 18.00\",\n" +
            "zone: {\n" +
            "zoneId: 14\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "address: \"21 de Setiembre y Luis de la Torre\",\n" +
            "city: {\n" +
            "cityId: 1,\n" +
            "name: \"Montevideo\"\n" +
            "},\n" +
            "creationDate: \"2014-09-03T03:57:53.07Z\",\n" +
            "email: \"reservas@dkdakota.com\",\n" +
            "id: 1764,\n" +
            "imageId: 31,\n" +
            "isDeleted: false,\n" +
            "latitude: -34.917851,\n" +
            "longitude: -56.157314,\n" +
            "modifiedDate: \"2014-09-03T04:06:55.497Z\",\n" +
            "name: \"Dakota\",\n" +
            "notes: \"Somos el primer restaurante Steakhouse & Bar americano en Montevideo, el lugar perfecto para compartir una deliciosa comida, celebrar y degustar una amplia variedad de platos, o simplemente disfrutar de un buen cóctel. Nuestra propuesta gastronómica incluye desde deliciosas entradas hasta las famosas “BBQ Ribs”, diferentes cortes de carne, hamburguesas caseras, pastas, pescados, entre otros, para poder sorprender hasta el más exquisito paladar. Para presentar un excelente plato es fundamental la calidad de los ingredientes, es por eso que mantenemos una relación estrecha con nuestros proveedores, asegurándonos de recibir los mejores productos. Procuramos prestar atención a los más pequeños detalles para poder brindarle un servicio rápido, eficiente y de alta calidad. Esperamos disfruten de la experiencia Dakota.\",\n" +
            "state: {\n" +
            "name: \"Montevideo\",\n" +
            "stateId: 1\n" +
            "},\n" +
            "telephone: \"27161510\",\n" +
            "type: \"shop\",\n" +
            "workingHours: \"Sáb a Dom: 12:30hs a 15:30hs.-19:00hs. a 2:00hs. Mar a Vier: 19:00hs. a 2:00hs.\",\n" +
            "zone: {\n" +
            "name: \"Villa Biarritz\",\n" +
            "zoneId: 1\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "address: \"Julio César e Iturriaga\",\n" +
            "city: {\n" +
            "cityId: 1,\n" +
            "name: \"Montevideo\"\n" +
            "},\n" +
            "creationDate: \"2014-09-03T03:57:53.07Z\",\n" +
            "email: \"reservas@dkdakota.com\",\n" +
            "id: 1771,\n" +
            "imageId: 31,\n" +
            "isDeleted: false,\n" +
            "latitude: -34.907432,\n" +
            "longitude: -56.139068,\n" +
            "modifiedDate: \"2014-09-03T04:06:55.497Z\",\n" +
            "name: \"Dakota Buceo\",\n" +
            "notes: \"Somos el primer restaurante Steakhouse & Bar americano en Montevideo, el lugar perfecto para compartir una deliciosa comida, celebrar y degustar una amplia variedad de platos, o simplemente disfrutar de un buen cóctel.\",\n" +
            "state: {\n" +
            "name: \"Montevideo\",\n" +
            "stateId: 1\n" +
            "},\n" +
            "telephone: \"27121234\",\n" +
            "type: \"shop\",\n" +
            "workingHours: \"Sáb a Dom: 12:30hs a 15:30hs.-19:00hs. a 2:00hs. Mar a Vier: 19:00hs. a 2:00hs.\",\n" +
            "zone: {\n" +
            "name: \"Buceo\",\n" +
            "zoneId: 2\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "address: \" Cra. 11 No 84 - 09 Local 5\",\n" +
            "creationDate: \"2014-09-04T20:55:54.753Z\",\n" +
            "email: \"\",\n" +
            "id: 1772,\n" +
            "imageId: 55,\n" +
            "isDeleted: false,\n" +
            "latitude: 4.667343,\n" +
            "longitude: -74.051984,\n" +
            "modifiedDate: \"2014-09-04T21:01:44.293Z\",\n" +
            "name: \"Carrera 11\",\n" +
            "notes: \"\",\n" +
            "telephone: \"\",\n" +
            "type: \"branch\",\n" +
            "workingHours: \"Lunes a Viernes de 9:00 am a 8:00 p.m. Sábados de 9.00 am a 5:00 pm. Domingos y Festivos: Sin servicio.\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Av. 19 No 120 - 71\",\n" +
            "creationDate: \"2014-09-04T20:58:29.74Z\",\n" +
            "email: \"\",\n" +
            "id: 1773,\n" +
            "imageId: 56,\n" +
            "isDeleted: false,\n" +
            "latitude: 4.701639,\n" +
            "longitude: -74.049605,\n" +
            "modifiedDate: \"2014-09-04T21:04:16.677Z\",\n" +
            "name: \"Calle 122\",\n" +
            "notes: \"\",\n" +
            "telephone: \"\",\n" +
            "type: \"branch\",\n" +
            "workingHours: \"Lunes a Viernes de 8:00 am a 7:00 pm Sábado de 9:00 am a 5:00 pm. Domingos y Festivos: Sin servicio\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Avenida 15 No. 123 - 30, Centro Comercial Unicentro\",\n" +
            "creationDate: \"2014-09-04T21:27:52.997Z\",\n" +
            "email: \"\",\n" +
            "id: 1774,\n" +
            "imageId: 57,\n" +
            "isDeleted: false,\n" +
            "latitude: 4.701206,\n" +
            "longitude: -74.042041,\n" +
            "modifiedDate: \"2014-09-04T21:27:52.997Z\",\n" +
            "name: \"Falabella Unicentro\",\n" +
            "notes: \"\",\n" +
            "telephone: \"\",\n" +
            "type: \"shop\",\n" +
            "workingHours: \"Lunes - Sábado 10:00am - 9:00pm Domingo y festivos 10:00am - 8:00pm\"\n" +
            "},\n" +
            "{\n" +
            "address: \"Av. Cr. 72 # 80-94 Local 130-350, Centro comercial Titán Plaza\",\n" +
            "creationDate: \"2014-09-04T21:34:13.923Z\",\n" +
            "email: \"\",\n" +
            "id: 1775,\n" +
            "imageId: 58,\n" +
            "isDeleted: false,\n" +
            "latitude: 4.694667,\n" +
            "longitude: -74.087001,\n" +
            "modifiedDate: \"2014-09-04T21:34:13.923Z\",\n" +
            "name: \"Falabella Titan Plaza\",\n" +
            "notes: \"\",\n" +
            "telephone: \"\",\n" +
            "type: \"shop\",\n" +
            "workingHours: \"Lunes - Sábados 10:00am - 8:00pm Domingos 10:00am - 8:00pm o 10:00am - 9:00pm cuando el lunes es festivo Festivos 10:00am - 8:00pm \"\n" +
            "}\n" +
            "],\n" +
            "benefits: [\n" +
            "{\n" +
            "associatedPointsOfInterest: [\n" +
            "{\n" +
            "creationDate: \"0001-01-01T08:00:00Z\",\n" +
            "id: 1764,\n" +
            "isDeleted: false,\n" +
            "latitude: 0,\n" +
            "longitude: 0,\n" +
            "modifiedDate: \"0001-01-01T08:00:00Z\"\n" +
            "},\n" +
            "{\n" +
            "creationDate: \"0001-01-01T08:00:00Z\",\n" +
            "id: 1771,\n" +
            "isDeleted: false,\n" +
            "latitude: 0,\n" +
            "longitude: 0,\n" +
            "modifiedDate: \"0001-01-01T08:00:00Z\"\n" +
            "}\n" +
            "],\n" +
            "backgroundColor: \"rgb(220, 220, 220)\",\n" +
            "body: \"15% de descuento en Dakota hasta el fin de semana\",\n" +
            "creationDate: \"2014-09-03T04:08:20.63Z\",\n" +
            "detailFormat: \"textAndImage\",\n" +
            "detailImageId: 35,\n" +
            "expirationDate: \"2015-07-10T07:00:00Z\",\n" +
            "id: 1,\n" +
            "isDeleted: false,\n" +
            "listFormat: \"textAndLeftImage\",\n" +
            "listImageId: 51,\n" +
            "modifiedDate: \"2014-09-05T22:42:40.787Z\",\n" +
            "moreInformationUrl: \"http://www.dkdakota.com\",\n" +
            "publishedDate: \"2014-09-03T07:00:00Z\",\n" +
            "textColor: \"rgb(18, 28, 48)\",\n" +
            "title: \"15% de descuento en Dakota\",\n" +
            "type: \"restaurants\"\n" +
            "}\n" +
            "],\n" +
            "contactItemsGroups: [\n" +
            "{\n" +
            "creationDate: \"2014-07-07T18:50:58.62Z\",\n" +
            "id: 1,\n" +
            "isDeleted: false,\n" +
            "items: [\n" +
            "{\n" +
            "creationDate: \"2014-07-03T18:23:39.87Z\",\n" +
            "data: {\n" +
            "latitude: 0,\n" +
            "longitude: 0\n" +
            "},\n" +
            "id: 1,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-03T18:25:54.86Z\",\n" +
            "name: \"Central\",\n" +
            "order: 1,\n" +
            "type: \"phone\",\n" +
            "value: \"29291616\"\n" +
            "},\n" +
            "{\n" +
            "creationDate: \"2014-07-03T18:25:54.933Z\",\n" +
            "data: {\n" +
            "latitude: 0,\n" +
            "longitude: 0\n" +
            "},\n" +
            "id: 2,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-03T18:25:54.933Z\",\n" +
            "name: \"Banking\",\n" +
            "order: 2,\n" +
            "type: \"url\",\n" +
            "value: \"www.infocorp.com.uy\"\n" +
            "},\n" +
            "{\n" +
            "creationDate: \"2014-07-07T18:50:58.75Z\",\n" +
            "id: 3,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T14:53:21.007Z\",\n" +
            "name: \"Síguenos en Facebook\",\n" +
            "order: 3,\n" +
            "type: \"facebook\",\n" +
            "value: \"www.facebook.com/infocorpgroup.aspx\"\n" +
            "},\n" +
            "{\n" +
            "creationDate: \"2014-07-08T14:51:34.83Z\",\n" +
            "id: 7,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T18:06:09.99Z\",\n" +
            "name: \"Sitios corporativos\",\n" +
            "order: 4,\n" +
            "type: \"text\",\n" +
            "value: \"Es importante entender que esta información no tiene acción asociada\"\n" +
            "}\n" +
            "],\n" +
            "modifiedDate: \"2014-07-25T14:53:17.343Z\",\n" +
            "name: \"Infocorp\",\n" +
            "order: 1\n" +
            "},\n" +
            "{\n" +
            "creationDate: \"2014-07-08T14:43:41.397Z\",\n" +
            "id: 2,\n" +
            "isDeleted: false,\n" +
            "items: [\n" +
            "{\n" +
            "creationDate: \"2014-07-08T14:43:41.43Z\",\n" +
            "id: 4,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T14:43:41.43Z\",\n" +
            "name: \"Website corporativo\",\n" +
            "order: 1,\n" +
            "type: \"url\",\n" +
            "value: \"https://www.bancosantander.es\"\n" +
            "},\n" +
            "{\n" +
            "creationDate: \"2014-07-08T14:43:41.453Z\",\n" +
            "id: 5,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T14:43:41.453Z\",\n" +
            "name: \"Call center principal\",\n" +
            "order: 2,\n" +
            "type: \"phone\",\n" +
            "value: \"001 787 2731111\"\n" +
            "}\n" +
            "],\n" +
            "modifiedDate: \"2014-07-25T14:53:17.343Z\",\n" +
            "name: \"Santander Casa central\",\n" +
            "order: 3\n" +
            "},\n" +
            "{\n" +
            "creationDate: \"2014-07-08T14:49:19.877Z\",\n" +
            "id: 3,\n" +
            "isDeleted: false,\n" +
            "items: [\n" +
            "{\n" +
            "creationDate: \"2014-07-08T14:49:19.903Z\",\n" +
            "id: 6,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T14:49:19.903Z\",\n" +
            "name: \"Video corporativos\",\n" +
            "order: 1,\n" +
            "type: \"youTube\",\n" +
            "value: \"http://www.youtube.com\"\n" +
            "}\n" +
            "],\n" +
            "modifiedDate: \"2014-07-25T14:53:17.343Z\",\n" +
            "name: \"Santander Uruguay\",\n" +
            "order: 2\n" +
            "}\n" +
            "],\n" +
            "linksOfInterestGroups: [\n" +
            "{\n" +
            "creationDate: \"2014-07-08T15:02:55.413Z\",\n" +
            "id: 1,\n" +
            "isDeleted: false,\n" +
            "linksOfInterest: [\n" +
            "{\n" +
            "creationDate: \"2014-07-08T15:02:55.473Z\",\n" +
            "id: 1,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T15:02:55.473Z\",\n" +
            "name: \"Grupo Sancor Seguros\",\n" +
            "order: 1,\n" +
            "url: \"https://www.gruposancorseguros.com/\"\n" +
            "},\n" +
            "{\n" +
            "creationDate: \"2014-07-08T15:04:30.147Z\",\n" +
            "id: 2,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T15:04:30.147Z\",\n" +
            "name: \"Tarjeta Visa\",\n" +
            "order: 2,\n" +
            "url: \"http://www.tarjetavisa.com.uy/\"\n" +
            "},\n" +
            "{\n" +
            "creationDate: \"2014-07-08T15:04:30.19Z\",\n" +
            "id: 3,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T15:04:30.19Z\",\n" +
            "name: \"Tarjeta Mastercard\",\n" +
            "order: 3,\n" +
            "url: \"http://www.mastercard.com/\"\n" +
            "}\n" +
            "],\n" +
            "modifiedDate: \"2014-08-07T18:52:14.667Z\",\n" +
            "name: \"Empresas del grupo\",\n" +
            "order: 1\n" +
            "},\n" +
            "{\n" +
            "creationDate: \"2014-07-08T15:06:38.317Z\",\n" +
            "id: 2,\n" +
            "isDeleted: false,\n" +
            "linksOfInterest: [\n" +
            "{\n" +
            "creationDate: \"2014-07-08T15:06:38.343Z\",\n" +
            "id: 4,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T15:06:38.343Z\",\n" +
            "name: \"Suat Emergencias\",\n" +
            "order: 1,\n" +
            "url: \"http://www.suat.com.uy/\"\n" +
            "},\n" +
            "{\n" +
            "creationDate: \"2014-07-08T15:06:38.37Z\",\n" +
            "id: 5,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T15:06:38.37Z\",\n" +
            "name: \"Hospital Británcio\",\n" +
            "order: 2,\n" +
            "url: \"http://www.hospitalbritanico.org.uy/\"\n" +
            "}\n" +
            "],\n" +
            "modifiedDate: \"2014-08-07T18:52:48.767Z\",\n" +
            "name: \"Sitios de emergencias con convenio2\",\n" +
            "order: 2\n" +
            "}\n" +
            "],\n" +
            "frequentlyAskedQuestions: [\n" +
            "{\n" +
            "answer: \"Debes bloquear inmediatamente tus Tarjetas llamando al (123) 456n 7890 (servicio disponible las 24 horas) o bien dirigirse a la Mesón de Atención al Cliente de la sucursal más cercana.\",\n" +
            "creationDate: \"2014-06-19T15:00:49.207Z\",\n" +
            "id: 1,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-06-19T15:06:05.633Z\",\n" +
            "order: 4,\n" +
            "question: \"Qué debo hacer si se extravía o roban mi Tarjeta?\",\n" +
            "relatedFrequentlyAskedQuestionsIds: [ ]\n" +
            "},\n" +
            "{\n" +
            "answer: \"Un depósito a plazo es un producto que se contrata a un tipo de interés determinado, que el cliente recibe mediante rentas periódicas (por ejemplo trimestrales) o a su vencimiento.\",\n" +
            "creationDate: \"2014-06-19T15:01:33.65Z\",\n" +
            "id: 2,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-06-19T15:06:05.633Z\",\n" +
            "order: 2,\n" +
            "question: \"Qué es una IPF (imposición a plazo fijo)?\",\n" +
            "relatedFrequentlyAskedQuestionsIds: [ ]\n" +
            "},\n" +
            "{\n" +
            "answer: \"Los intereses generados son considerados rendimientos del capital mobiliario, sujetos a una retención a cuenta del IRPF del 21%.\",\n" +
            "creationDate: \"2014-06-19T15:02:25.217Z\",\n" +
            "id: 3,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-06-19T15:06:05.633Z\",\n" +
            "order: 3,\n" +
            "question: \"Cómo es la fiscalidad de los depósitos?\",\n" +
            "relatedFrequentlyAskedQuestionsIds: [ ]\n" +
            "},\n" +
            "{\n" +
            "answer: \"Si usted se da de alta en IC-Banking podrá beneficiarse, entre otros, de los siguientes servicios: Posición integral. Cuentas: Detalle de movimientos, saldos y movimientos de los últimos 18 meses. Solicitud de apertura de Cuenta. Transferencias (puntuales, periodicas y diferidas) y Traspasos. Domiciliación de Recibos. Solicitud de talonario. Fondos de Inversión: Saldos y movimientos. Contratación. Aportaciones y Reembolsos. Préstamos: Contratación de préstamos preconcedidos. Tarjetas de Crédito: Movimientos de los últimos 12 meses. Solicitud de Tarjeta/Tarjeta adicional. Cambio Modalidad de Pago. Petición Número Secreto.\",\n" +
            "creationDate: \"2014-06-19T15:04:12.777Z\",\n" +
            "id: 4,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-06-19T15:06:05.633Z\",\n" +
            "order: 1,\n" +
            "question: \"Qué servicios ofrece IC-Banking?\",\n" +
            "relatedFrequentlyAskedQuestionsIds: [ ]\n" +
            "},\n" +
            "{\n" +
            "answer: \"Cualquier cliente del Banco puede utilizar los servicios de IC-Banking. Para poder acceder a la consulta de sus productos IC-Banking (ej. consulta de saldos y movimientos), debe darse de alta en IC-Banking. Sólo necesita una tarjeta de crédito o débito IC-Banking o responder algunas preguntas sobre sus cuentas. Una vez introducidos estos datos, deberá elegir una clave de acceso y ya podrá acceder a IC-Banking siempre que desee, sin más que introducir su identificación (NIF, CIF, Número de Pasaporte o NIE) y su clave de acceso. Para operar en IC-Banking con sus productos IC-Banking (ej. realizar transferencias, etc.), deberá obtener primero su Firma Multicanal, que le permitirá confirmar cualquier operación que usted quiera realizar. Si todavía no dispone ella, solicítela en cualquiera de nuestras oficinas IC-Banking. Para obtenerla, deberá firmar el contrato de Servicio MultiCanal, que le dará acceso a todos los Canales a Distancia que usted desee utilizar. Si usted ya dispone de su Firma Multicanal, a través de alta en IC-Banking podrá comenzar a operar en IC-Banking de manera inmediata\",\n" +
            "creationDate: \"2014-06-19T15:07:41.863Z\",\n" +
            "id: 5,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-06-19T15:07:41.863Z\",\n" +
            "order: 5,\n" +
            "question: \"Cómo puedo empezar a utilizar los servicios de IC-Banking?\",\n" +
            "relatedFrequentlyAskedQuestionsIds: [ ]\n" +
            "},\n" +
            "{\n" +
            "answer: \"Uno de los aspectos prioritarios al ofrecer gran número de servicios bancarios a través de Internet es proporcionar la máxima seguridad a cada operación, y con el IC-Banking puede estar tranquilo. Cada vez que usted realice una transferencia con IC-Banking, recibirá en su teléfono móvil un código secreto que deberá introducir para concluir la operación. Así impediremos transferencias fraudulentas si terceras personas hubieran conocido su firma Multicanal. A modo de ejemplo, estos son sólo algunos de los sistemas de seguridad en IC-Banking\",\n" +
            "creationDate: \"2014-06-19T15:10:02.58Z\",\n" +
            "id: 6,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-06-19T15:10:02.58Z\",\n" +
            "order: 6,\n" +
            "question: \"Es realmente seguro operar en IC-Banking?\",\n" +
            "relatedFrequentlyAskedQuestionsIds: [ ]\n" +
            "},\n" +
            "{\n" +
            "answer: \"Desde el punto de vista del consumidor, la banca en línea ofrece una serie de ventajas que permiten crear valor (Muñoz Leiva, 2008: 57): Comodidad y servicios de conveniencia, 24 horas al día, 7 días a la semana. Operaciones desde casa. Acceso global. Ahorro en tiempo. Ahorro en costes para el banco que pueden o deben repercutir en el cliente. Puede ser más barato que el teléfono, sobre todo si se tiene tarifa plana o el teléfono de información es una línea 902. Transparencia en la información. Capacidad de elección de los clientes. Oferta de productos y servicios personalizados. No obstante se ha detectado un conjunto de obstáculos o inconvenientes que inhiben la óptima adopción de la banca online (Muñoz Leiva, 2008: 59): Preocupación por la seguridad (virus, piratas,...) y por la información personal y confidencial. Propia intangibilidad y separación física entre el cliente y la entidad. Límite de servicios y burocracia afuera de línea (solventado con el paso del tiempo). Ausencia de información sobre el uso y servicios ofrecidos y de habilidades tecnológicas entre los usuarios. Baja penetración de Internet en algunas zonas rurales o países en vías de desarrollo. Procedimiento y medidas de seguridad[editar] Normalmente se opera registrándose con los datos del cliente y una clave o un certificado digital. Otras medidas de seguridad son: Usar la conexión cifrada con cifrado fuerte, para el caso de que pueda haber un sniffer. Ver SSL/TLS. Guardar la contraseña en un lugar seguro o, mucho mejor, memorizarla y destruirla. Normalmente hay algún método para recuperarla si se olvida: se puede solicitar en el cajero, vía telefónica o en la misma web se puede solicitar el envío a casa. Tras su envío a casa, además se puede obligar a solicitar su activación por otro medio, como el teléfono. Esto minimiza los peligros de que se intercepte el correo. Si la clave es interceptada y utilizada sin que el usuario se entere, es el banco sobre quien recae la responsabilidad. Para la activación se pueden solicitar algunos datos de seguridad, para disminuir aún más los riesgos. Los navegadores pueden almacenar información del formulario de ingreso en el sitio de la banca en línea. Si existe riesgo de que se pueda ver esta información (por ejemplo, si no es el ordenador de casa) hay que evitar que el navegador almacene estos datos, sobre todo la clave. Además puede ser conveniente que no guarde las cookies del banco, ya que si el servidor las reconoce, puede rellenar ciertos datos del formulario automáticamente. Este es el caso de la Wikipedia, que según la cookie rellena con el nombre de usuario. Además de la clave se suele usar otra clave llamada firma que es necesaria para realizar movimientos de dinero. La medidas de seguridad sobre la firma deberán ser aun mayores. Si no utilizamos un ordenador de confianza, puede tener instalado un programa que capture la teclas pulsadas del teclado. Como medida de seguridad adicional, se puede introducir la contraseña pulsando unos botones mediante el ratón. Es más difícil averiguar el número pulsado a partir de la posición del ratón y más aún si los botones cambian de posición cada vez que se solicita autenticación.\",\n" +
            "creationDate: \"2014-07-08T15:12:21.57Z\",\n" +
            "id: 7,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T15:12:21.57Z\",\n" +
            "order: 7,\n" +
            "question: \"¿Que ventaja tiene operar con el banco de forma remota?\",\n" +
            "relatedFrequentlyAskedQuestionsIds: [ ]\n" +
            "},\n" +
            "{\n" +
            "answer: \"La tarjeta de crédito es un instrumento material de identificación del usuario, que puede ser una tarjeta de plástico con una banda magnética, un microchip y un número en relieve. Es emitida por un banco o entidad financiera que autoriza a la persona a cuyo favor es emitida, a utilizarla como medio de pago en los negocios adheridos al sistema, mediante su firma y la exhibición de la tarjeta. Es otra modalidad de financiación, por lo tanto, el usuario supone asumir la obligación de devolver el importe dispuesto y de pagar los intereses, comisiones bancarias y gastos pactados. Entre las más conocidas del mercado están: Visa, American Express, MasterCard, Diners Club, JCB, Discover, Cabal, entre otras. Listado de entidades en línea (virtuales)[editar] Bancos ActivoBank, banco en línea perteneciente al Banco Sabadell bancopopular-e, banco en línea perteneciente al Banco Popular Uno-e, banco en línea perteneciente a BBVA Openbank, banco en línea perteneciente al Grupo Santander iBanesto, banco en línea perteneciente a Banesto (Grupo Santander) oficinadirecta.com, banco en línea perteneciente a Banco Pastor Self Bank, que forma parte del grupo \"la Caixa\" y Société Générale ING Direct, banco en línea perteneciente a ING Group Cathedral bank Inversis Banco, especializado en servicios financieros. IWBank Cortal Consors, banco en línea perteneciente a BNP Paribas BankiaLink, banco en línea perteneciente a Bankia EVO Banco, marca comercial de Novagalicia BancoBAN Homebanking, banco línea perteneciente a Banco Continental S.A de Honduras.\",\n" +
            "creationDate: \"2014-07-08T15:14:37.73Z\",\n" +
            "id: 8,\n" +
            "isDeleted: false,\n" +
            "modifiedDate: \"2014-07-08T15:17:52.713Z\",\n" +
            "order: 8,\n" +
            "question: \"¿Que prestamos con tasa cero tengo disponible como cliente preferencial del banco VIP?\",\n" +
            "relatedFrequentlyAskedQuestionsIds: [ ]\n" +
            "}\n" +
            "],\n" +
            "exchangeRates: [\n" +
            "{\n" +
            "sourceCurrency: {\n" +
            "currencyId: \"858\",\n" +
            "currencyAlpha3Code: \"UYU\",\n" +
            "currencyDescription: \"Uruguayan peso\",\n" +
            "currencySymbol: \"$\"\n" +
            "},\n" +
            "destinationCurrency: {\n" +
            "currencyId: \"32\",\n" +
            "currencyAlpha3Code: \"ARS\",\n" +
            "currencyDescription: \"Argentine peso\",\n" +
            "currencySymbol: \"$\"\n" +
            "},\n" +
            "buyRate: 4.49,\n" +
            "sellRate: 5.26,\n" +
            "official: 5.09\n" +
            "},\n" +
            "{\n" +
            "sourceCurrency: {\n" +
            "currencyId: \"858\",\n" +
            "currencyAlpha3Code: \"UYU\",\n" +
            "currencyDescription: \"Uruguayan peso\",\n" +
            "currencySymbol: \"$\"\n" +
            "},\n" +
            "destinationCurrency: {\n" +
            "currencyId: \"840\",\n" +
            "currencyAlpha3Code: \"USD\",\n" +
            "currencyDescription: \"United States dollar\",\n" +
            "currencySymbol: \"US$\"\n" +
            "},\n" +
            "buyRate: 19.15,\n" +
            "sellRate: 20.25,\n" +
            "official: 19.95\n" +
            "},\n" +
            "{\n" +
            "sourceCurrency: {\n" +
            "currencyId: \"858\",\n" +
            "currencyAlpha3Code: \"UYU\",\n" +
            "currencyDescription: \"Uruguayan peso\",\n" +
            "currencySymbol: \"$\"\n" +
            "},\n" +
            "destinationCurrency: {\n" +
            "currencyId: \"858\",\n" +
            "currencyAlpha3Code: \"UYU\",\n" +
            "currencyDescription: \"Uruguayan peso\",\n" +
            "currencySymbol: \"$\"\n" +
            "},\n" +
            "buyRate: 1,\n" +
            "sellRate: 1,\n" +
            "official: 1\n" +
            "},\n" +
            "{\n" +
            "sourceCurrency: {\n" +
            "currencyId: \"858\",\n" +
            "currencyAlpha3Code: \"UYU\",\n" +
            "currencyDescription: \"Uruguayan peso\",\n" +
            "currencySymbol: \"$\"\n" +
            "},\n" +
            "destinationCurrency: {\n" +
            "currencyId: \"978\",\n" +
            "currencyAlpha3Code: \"EUR\",\n" +
            "currencyDescription: \"Euro\",\n" +
            "currencySymbol: \"€\"\n" +
            "},\n" +
            "buyRate: 25.1,\n" +
            "sellRate: 33.33,\n" +
            "official: 31.89\n" +
            "},\n" +
            "{\n" +
            "sourceCurrency: {\n" +
            "currencyId: \"858\",\n" +
            "currencyAlpha3Code: \"UYU\",\n" +
            "currencyDescription: \"Uruguayan peso\",\n" +
            "currencySymbol: \"$\"\n" +
            "},\n" +
            "destinationCurrency: {\n" +
            "currencyId: \"986\",\n" +
            "currencyAlpha3Code: \"BRL\",\n" +
            "currencyDescription: \"Brazilian real\",\n" +
            "currencySymbol: \"R$\"\n" +
            "},\n" +
            "buyRate: 10.49,\n" +
            "sellRate: 11,\n" +
            "official: 10.5\n" +
            "}\n" +
            "]\n" +
            "}";

    public static PublicInfoDTO getPublicInfo() {
        return HttpUtils.typeFromStringData(OFFLINE_JSON, PublicInfoDTO.class);
    }
}
