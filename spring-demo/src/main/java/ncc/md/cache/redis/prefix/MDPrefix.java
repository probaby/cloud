package ncc.md.cache.redis.prefix;

/**
 * @author huangbiaof
 * @data 创建时间：2019/9/17 10:56
 */
public class MDPrefix extends BasePrefix{

	private MDPrefix(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}

	private MDPrefix(int expireSeconds, String prefix,String tenend) {
		super(expireSeconds, prefix);
	}

	public static MDPrefix mdPrefix = new MDPrefix(0,"mdCache");
	public static MDPrefix modulePrefix = new MDPrefix(0,"mop");
	public static MDPrefix componentPrefix = new MDPrefix(0,"mdCache");
	public static MDPrefix typeCompPrefix = new MDPrefix(0,"mdCache");
	public static MDPrefix typeFullClassPrefix = new MDPrefix(0,"mdCache");
	public static MDPrefix busiOperationID_compIDPrefix = new MDPrefix(0,"mdCache");
	//public static MDPrefix busiOperationID_compIDPrefix = new MDPrefix(0,"mdCache");

}
