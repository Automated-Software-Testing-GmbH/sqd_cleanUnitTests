@MediumTest
public void testCloneNonBareRepoFromLocalTestServer() throws Exception {
    Clone cloneOp = new Clone(false, integrationGitServerURIFor("small-repo.early.git"), helper().newFolder());

    Repository repo = executeAndWaitFor(cloneOp);

    assertThat(repo, hasGitObject("ba1f63e4430bff267d112b1e8afc1d6294db0ccc"));

    File readmeFile = new File(repo.getWorkTree(), "README");
    assertThat(readmeFile, exists());
    assertThat(readmeFile, ofLength(12));
}
 
@Test
public void testSpinner() {
    for (Map.Entry entry : sourcesMap.entrySet()) {

        String id = entry.getKey();
        Object resultObject = resultsMap.get(id);
        if (resultObject instanceof EventsModel) {
            EventsModel result = (EventsModel) resultObject;
            if (result.testSpinner.runTest) {
                System.out.println("Testing " + id + " (testSpinner)");
                //System.out.println(result);
                AnswerObject answer = new AnswerObject(entry.getValue(), "", new CookieManager(), "");
                EventsScraper scraper = new EventsScraper(RuntimeEnvironment.application, answer);
                SpinnerAdapter spinnerAdapter = scraper.spinnerAdapter();
                assertEquals(spinnerAdapter.getCount(), result.testSpinner.data.size());
                for (int i = 0; i < spinnerAdapter.getCount(); i++) {
                    assertEquals(spinnerAdapter.getItem(i), result.testSpinner.data.get(i));
                }
            }
         }
    }
}
 

public class TagEncodingTest extends BrambleTestCase {
	private final CryptoComponent crypto;
	private final SecretKey tagKey;
	private final long streamNumber = 1234567890;

	public TagEncodingTest() {
		crypto = new CryptoComponentImpl(new TestSecureRandomProvider());
		tagKey = TestUtils.getSecretKey();
	}

	@Test
	public void testKeyAffectsTag() throws Exception {
		Set set = new HashSet<>();
		for (int i = 0; i < 100; i++) {
			byte[] tag = new byte[TAG_LENGTH];
			SecretKey tagKey = TestUtils.getSecretKey();
			crypto.encodeTag(tag, tagKey, PROTOCOL_VERSION, streamNumber);
			assertTrue(set.add(new Bytes(tag)));
		}
	}
 ...
}
            

public class ExampleUnitTest {
    @Test
	public void addition_isCorrect() throws Exception {
		assertEquals(4, 2 + 2);
	}

    @Test
    public void shareProblem() throws InterruptedException {
    	.....
		Observable.just(200)
 		.subscribeOn(Schedulers.newThread())
		.subscribe(begin.asAction());
		begin.set(200);
		Thread.sleep(1000);
		assertEquals(beginTime.get(), "200");
    	.....
	}
	.....
}
            

@Test
public void testXmlSanitizer() {
    boolean valid = XmlSanitizer.isValid("Fritzbox");
    assertEquals("Fritzbox is valid", true, valid);
    System.out.println("Pure ASCII test - passed");

    valid = XmlSanitizer.isValid("Fritz Box");
    assertEquals("Spaces are valid", true, valid);
    System.out.println("Spaces test - passed");

    valid = XmlSanitizer.isValid("Frützbüx");
    assertEquals("Frützbüx is invalid", false, valid);
    System.out.println("No ASCII test - passed");

    valid = XmlSanitizer.isValid("Fritz!box");
    assertEquals("Exclamation mark is valid", true, valid);
    System.out.println("Exclamation mark test - passed");

    valid = XmlSanitizer.isValid("Fritz.box");
    assertEquals("Exclamation mark is valid", true, valid);
    System.out.println("Dot test - passed");

    valid = XmlSanitizer.isValid("Fritz-box");
    assertEquals("Minus is valid", true, valid);
    System.out.println("Minus test - passed");

    valid = XmlSanitizer.isValid("Fritz-box");
    assertEquals("Minus is valid", true, valid);
    System.out.println("Minus test - passed");
}
            
@Test
public void NmeaSentence_GPGSA_ReadValidValues(){
    NmeaSentence nmeaSentence = new NmeaSentence("$GPGSA,A,3,04,05,,09,12,,,24,,,,,2.5,1.3,2.1*39");
    assertThat("GPGSA - read PDOP", nmeaSentence.getLatestPdop(), is("2.5"));
    assertThat("GPGSA - read HDOP", nmeaSentence.getLatestHdop(), is("1.3"));
    assertThat("GPGSA - read VDOP", nmeaSentence.getLatestVdop(), is("2.1"));
}
            


public void testCredGetFullSampleV1() throws Throwable{
//        ScrapedCredentials credentials =  innerCredTest(FULL_SAMPLE_v1);
//        assertEquals("p4ssw0rd", credentials.pass);
//        assertEquals("user@example.com",credentials.user);
}
            

@Test
public void realCase() {
    Point p34 = new Point("34", 556506.667, 172513.91, 620.34, true);
    Point p45 = new Point("45", 556495.16, 172493.912, 623.37, true);
    Point p47 = new Point("47", 556612.21, 172489.274, 0.0, true);
    Abriss a = new Abriss(p34, false);
    a.removeDAO(CalculationsDataSource.getInstance());
    a.getMeasures().add(new Measure(p45, 0.0, 91.6892, 23.277, 1.63));
    a.getMeasures().add(new Measure(p47, 281.3521, 100.0471, 108.384, 1.63));

    try {
        a.compute();
    } catch (CalculationException e) {
        Assert.fail(e.getMessage());
    }

    // test intermediate values with point 45
    Assert.assertEquals("233.2405",
        this.df4.format(a.getResults().get(0).getUnknownOrientation()));
    Assert.assertEquals("233.2435",
        this.df4.format(a.getResults().get(0).getOrientedDirection()));
    Assert.assertEquals("-0.1", this.df1.format(
        a.getResults().get(0).getErrTrans()));

    // test intermediate values with point 47
    Assert.assertEquals("233.2466",
        this.df4.format(a.getResults().get(1).getUnknownOrientation()));
    Assert.assertEquals("114.5956",
        this.df4.format(a.getResults().get(1).getOrientedDirection()));
    Assert.assertEquals("0.5", this.df1.format(
        a.getResults().get(1).getErrTrans()));

    // test final results
    Assert.assertEquals("233.2435", this.df4.format(a.getMean()));
    Assert.assertEquals("43", this.df0.format(a.getMSE()));
    Assert.assertEquals("30", this.df0.format(a.getMeanErrComp()));
}
            

protected void setUp() throws Exception {
    assetManager = getInstrumentation().getContext().getAssets();
    certificateFactory = CertificateFactory.getInstance("X.509");

    infoDebianTestCA = loadCertificateInfo("DebianTestCA.pem");
    infoDebianTestNoCA = loadCertificateInfo("DebianTestNoCA.pem");
    infoGTECyberTrust = loadCertificateInfo("GTECyberTrustGlobalRoot.pem");

    // user-submitted test cases
	infoMehlMX = loadCertificateInfo("mehl.mx.pem");
}

public void testIsCA() {
    assertTrue(infoDebianTestCA.isCA());
    assertFalse(infoDebianTestNoCA.isCA());
    assertNull(infoGTECyberTrust.isCA());

    assertFalse(infoMehlMX.isCA());
}
            

@Ignore("disabled for now as this test is too flaky")
public void peerPriority() throws Exception {
	final List addresses = Lists.newArrayList(
    	new InetSocketAddress("localhost", 2000),
        new InetSocketAddress("localhost", 2001),
        new InetSocketAddress("localhost", 2002)
	);
    peerGroup.addConnectedEventListener(connectedListener);
    .....
}
            

@Test
public void testDecrypt() throws Exception {
    FileInputStream file = new FileInputStream(ENCRYPTED_DATA_FILE_4_14);
    byte[] enfileData = new byte[file.available()];
    FileInputStream input = new FileInputStream(DECRYPTED_DATA_FILE_4_14);
    byte[] fileData = new byte[input.available()];
    input.read(fileData);
    input.close();
    file.read(enfileData);
    file.close();
    String expectedResult = new String(fileData, "UTF-8");
    assertEquals("Testing simple decrypt",expectedResult, Cryptographer.decrypt(enfileData, "test"));
}

@Test
public void testEncrypt() throws Exception {
    String xml = readFileAsString(DECRYPTED_DATA_FILE_4_14);
    byte[] encrypted = Cryptographer.encrypt(xml, "test");
    String decrypt = Cryptographer.decrypt(encrypted, "test");
    assertEquals(xml, decrypt);
}
            

@Test
public void testGetLocalTimeAsCalendar() {
    Calendar localTime = calc.getLocalTimeAsCalendar(BigDecimal.valueOf(15.5D), Calendar.getInstance());
    assertEquals(15, localTime.get(Calendar.HOUR_OF_DAY));
    assertEquals(30, localTime.get(Calendar.MINUTE));
}
            

public void testPersistence() throws Exception {
    File tempFile = File.createTempFile("systemstate-", ".txt");
    try {
        SystemState a = new SystemState(then, 27, false, bootTimestamp);
        a.addInstalledApp("a.b.c", "ABC", "1.2.3");

        a.writeToFile(tempFile);
        SystemState b = SystemState.readFromFile(tempFile);

        assertEquals(a, b);
    } finally {
        //noinspection ConstantConditions
        if (tempFile != null) {
            //noinspection ResultOfMethodCallIgnored
            tempFile.delete();
        }
    }
}
            
			
@Test
public void testTransform10mNEUAndBack() {
    Leg northEastAndUp10M = new Leg(10, 45, 45);
    Coord3D result = transformer.transform(Coord3D.ORIGIN, northEastAndUp10M);
    System.out.println("result = " + result);
    Leg reverse = new Leg(10, 225, -45);
    result = transformer.transform(result, reverse);
    assertEquals(Coord3D.ORIGIN, result);
}
            

@Test
public void testTrue() {
    assertEquals(true, true);
}
            

@Test
public void saveImage_noImageFile_ko() throws IOException {
File outputFile = File.createTempFile("prefix", "png", new File("/tmp"));
ProductImage image = new ProductImage("01010101010101", ProductImageField.FRONT, outputFile);
Response response = serviceWrite.saveImage(image.getCode(), image.getField(), image.getImguploadFront(), image.getImguploadIngredients(), image.getImguploadNutrition()).execute();
assertTrue(response.isSuccess());
assertThatJson(response.body())
    .node("status")
        .isEqualTo("status not ok");
}
            

@Test
public void test1() throws UnknownHostException {

    String peersPacket = "F8 4E 11 F8 4B C5 36 81 " +
        "CC 0A 29 82 76 5F B8 40 D8 D6 0C 25 80 FA 79 5C " +
        "FC 03 13 EF DE BA 86 9D 21 94 E7 9E 7C B2 B5 22 " +
        "F7 82 FF A0 39 2C BB AB 8D 1B AC 30 12 08 B1 37 " +
        "E0 DE 49 98 33 4F 3B CF 73 FA 11 7E F2 13 F8 74 " +
        "17 08 9F EA F8 4C 21 B0";

    byte[] payload = Hex.decode(peersPacket);

    byte[] ip = decodeIP4Bytes(payload, 5);

    assertEquals(InetAddress.getByAddress(ip).toString(), ("/54.204.10.41"));
}
            
public void testEdictExternSearch() throws Exception {
    final Intent i = new Intent(getInstrumentation().getContext(), ResultActivity.class);
    i.setAction(ResultActivity.EDICT_ACTION_INTERCEPT);
    i.putExtra(ResultActivity.EDICT_INTENTKEY_KANJIS, "空白");
	tester.startActivity(i);
	assertTrue(tester.getText(R.id.textSelectedDictionary).contains("Default"));
	final ListView lv = getActivity().getListView();
	assertEquals(1, lv.getCount());
	DictEntry entry = (DictEntry) lv.getItemAtPosition(0);
	assertEquals("Searching", entry.english);
	Thread.sleep(500);
	final Intent i2 = getStartedActivityIntent();
	final List result = (List) i2.getSerializableExtra(ResultActivity.INTENTKEY_RESULT_LIST);
	entry = result.get(0);
	assertEquals("(adj-na,n,adj-no) blank space/vacuum/space/null (NUL)/(P)", entry.english);
	assertEquals("空白", entry.getJapanese());
	assertEquals("くうはく", entry.reading);
	assertEquals(1, result.size());
}
            

@Test
public void hitGetPOICategoriesApi() throws Exception {
    POICategories poiCategories = apiClient.getPOICategories(16);
    for (POICategory category : poiCategories) {
      System.out.println(category.name() + ": " + category);
    }
}
            
