#### UUID Generation
* Best practice is to use 16 Byte binary to store 128 bits generated UUID
* Implmentation methode:
  Method 1:
```
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDBinaryType")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;
```
Method 2: (logically more readable at annotation level)
```
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;
```
Where the default hibernate strategy are:
(in `org.hibernate.id.factory.IdentifierGeneratorFactory`)
```
public DefaultIdentifierGeneratorFactory() {
        this.register("uuid2", UUIDGenerator.class);
        this.register("guid", GUIDGenerator.class);
        this.register("uuid", UUIDHexGenerator.class);
        this.register("uuid.hex", UUIDHexGenerator.class);
        this.register("assigned", Assigned.class);
        this.register("identity", IdentityGenerator.class);
        this.register("select", SelectGenerator.class);
        this.register("sequence", SequenceStyleGenerator.class);
        this.register("seqhilo", SequenceHiLoGenerator.class);
        this.register("increment", IncrementGenerator.class);
        this.register("foreign", ForeignGenerator.class);
        this.register("sequence-identity", SequenceIdentityGenerator.class);
        this.register("enhanced-sequence", SequenceStyleGenerator.class);
        this.register("enhanced-table", TableGenerator.class);
    }
```