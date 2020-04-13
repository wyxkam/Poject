package cn.pojo;

/**
 * 处方模板详细
 */
public class PrescriptionDetail {
    private Integer id;//主键ID
    private Integer prescriptionid;//处方模板ID
    private String name;//名称
    private Integer dosage;//单次用量
    private String usage;//用法
    private String frequentness;//频度
    private Integer days;//天数
    private Integer gross;//总量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(Integer prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getFrequentness() {
        return frequentness;
    }

    public void setFrequentness(String frequentness) {
        this.frequentness = frequentness;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getGross() {
        return gross;
    }

    public void setGross(Integer gross) {
        this.gross = gross;
    }
}
