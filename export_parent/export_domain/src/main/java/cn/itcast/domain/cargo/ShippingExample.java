package cn.itcast.domain.cargo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShippingExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShippingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andShippingOrderIdIsNull() {
            addCriterion("SHIPPING_ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdIsNotNull() {
            addCriterion("SHIPPING_ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdEqualTo(String value) {
            addCriterion("SHIPPING_ORDER_ID =", value, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdNotEqualTo(String value) {
            addCriterion("SHIPPING_ORDER_ID <>", value, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdGreaterThan(String value) {
            addCriterion("SHIPPING_ORDER_ID >", value, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHIPPING_ORDER_ID >=", value, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdLessThan(String value) {
            addCriterion("SHIPPING_ORDER_ID <", value, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdLessThanOrEqualTo(String value) {
            addCriterion("SHIPPING_ORDER_ID <=", value, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdLike(String value) {
            addCriterion("SHIPPING_ORDER_ID like", value, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdNotLike(String value) {
            addCriterion("SHIPPING_ORDER_ID not like", value, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdIn(List<String> values) {
            addCriterion("SHIPPING_ORDER_ID in", values, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdNotIn(List<String> values) {
            addCriterion("SHIPPING_ORDER_ID not in", values, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdBetween(String value1, String value2) {
            addCriterion("SHIPPING_ORDER_ID between", value1, value2, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andShippingOrderIdNotBetween(String value1, String value2) {
            addCriterion("SHIPPING_ORDER_ID not between", value1, value2, "shippingOrderId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("ORDER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("ORDER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("ORDER_TYPE =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("ORDER_TYPE <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("ORDER_TYPE >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_TYPE >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("ORDER_TYPE <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_TYPE <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("ORDER_TYPE like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("ORDER_TYPE not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("ORDER_TYPE in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("ORDER_TYPE not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("ORDER_TYPE between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("ORDER_TYPE not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andShipperIsNull() {
            addCriterion("SHIPPER is null");
            return (Criteria) this;
        }

        public Criteria andShipperIsNotNull() {
            addCriterion("SHIPPER is not null");
            return (Criteria) this;
        }

        public Criteria andShipperEqualTo(String value) {
            addCriterion("SHIPPER =", value, "shipper");
            return (Criteria) this;
        }

        public Criteria andShipperNotEqualTo(String value) {
            addCriterion("SHIPPER <>", value, "shipper");
            return (Criteria) this;
        }

        public Criteria andShipperGreaterThan(String value) {
            addCriterion("SHIPPER >", value, "shipper");
            return (Criteria) this;
        }

        public Criteria andShipperGreaterThanOrEqualTo(String value) {
            addCriterion("SHIPPER >=", value, "shipper");
            return (Criteria) this;
        }

        public Criteria andShipperLessThan(String value) {
            addCriterion("SHIPPER <", value, "shipper");
            return (Criteria) this;
        }

        public Criteria andShipperLessThanOrEqualTo(String value) {
            addCriterion("SHIPPER <=", value, "shipper");
            return (Criteria) this;
        }

        public Criteria andShipperLike(String value) {
            addCriterion("SHIPPER like", value, "shipper");
            return (Criteria) this;
        }

        public Criteria andShipperNotLike(String value) {
            addCriterion("SHIPPER not like", value, "shipper");
            return (Criteria) this;
        }

        public Criteria andShipperIn(List<String> values) {
            addCriterion("SHIPPER in", values, "shipper");
            return (Criteria) this;
        }

        public Criteria andShipperNotIn(List<String> values) {
            addCriterion("SHIPPER not in", values, "shipper");
            return (Criteria) this;
        }

        public Criteria andShipperBetween(String value1, String value2) {
            addCriterion("SHIPPER between", value1, value2, "shipper");
            return (Criteria) this;
        }

        public Criteria andShipperNotBetween(String value1, String value2) {
            addCriterion("SHIPPER not between", value1, value2, "shipper");
            return (Criteria) this;
        }

        public Criteria andConsigneeIsNull() {
            addCriterion("CONSIGNEE is null");
            return (Criteria) this;
        }

        public Criteria andConsigneeIsNotNull() {
            addCriterion("CONSIGNEE is not null");
            return (Criteria) this;
        }

        public Criteria andConsigneeEqualTo(String value) {
            addCriterion("CONSIGNEE =", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotEqualTo(String value) {
            addCriterion("CONSIGNEE <>", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeGreaterThan(String value) {
            addCriterion("CONSIGNEE >", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeGreaterThanOrEqualTo(String value) {
            addCriterion("CONSIGNEE >=", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLessThan(String value) {
            addCriterion("CONSIGNEE <", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLessThanOrEqualTo(String value) {
            addCriterion("CONSIGNEE <=", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLike(String value) {
            addCriterion("CONSIGNEE like", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotLike(String value) {
            addCriterion("CONSIGNEE not like", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeIn(List<String> values) {
            addCriterion("CONSIGNEE in", values, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotIn(List<String> values) {
            addCriterion("CONSIGNEE not in", values, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeBetween(String value1, String value2) {
            addCriterion("CONSIGNEE between", value1, value2, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotBetween(String value1, String value2) {
            addCriterion("CONSIGNEE not between", value1, value2, "consignee");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyIsNull() {
            addCriterion("NOTIFY_PARTY is null");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyIsNotNull() {
            addCriterion("NOTIFY_PARTY is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyEqualTo(String value) {
            addCriterion("NOTIFY_PARTY =", value, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyNotEqualTo(String value) {
            addCriterion("NOTIFY_PARTY <>", value, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyGreaterThan(String value) {
            addCriterion("NOTIFY_PARTY >", value, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyGreaterThanOrEqualTo(String value) {
            addCriterion("NOTIFY_PARTY >=", value, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyLessThan(String value) {
            addCriterion("NOTIFY_PARTY <", value, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyLessThanOrEqualTo(String value) {
            addCriterion("NOTIFY_PARTY <=", value, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyLike(String value) {
            addCriterion("NOTIFY_PARTY like", value, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyNotLike(String value) {
            addCriterion("NOTIFY_PARTY not like", value, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyIn(List<String> values) {
            addCriterion("NOTIFY_PARTY in", values, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyNotIn(List<String> values) {
            addCriterion("NOTIFY_PARTY not in", values, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyBetween(String value1, String value2) {
            addCriterion("NOTIFY_PARTY between", value1, value2, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andNotifyPartyNotBetween(String value1, String value2) {
            addCriterion("NOTIFY_PARTY not between", value1, value2, "notifyParty");
            return (Criteria) this;
        }

        public Criteria andLcNoIsNull() {
            addCriterion("LC_NO is null");
            return (Criteria) this;
        }

        public Criteria andLcNoIsNotNull() {
            addCriterion("LC_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLcNoEqualTo(String value) {
            addCriterion("LC_NO =", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoNotEqualTo(String value) {
            addCriterion("LC_NO <>", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoGreaterThan(String value) {
            addCriterion("LC_NO >", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoGreaterThanOrEqualTo(String value) {
            addCriterion("LC_NO >=", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoLessThan(String value) {
            addCriterion("LC_NO <", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoLessThanOrEqualTo(String value) {
            addCriterion("LC_NO <=", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoLike(String value) {
            addCriterion("LC_NO like", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoNotLike(String value) {
            addCriterion("LC_NO not like", value, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoIn(List<String> values) {
            addCriterion("LC_NO in", values, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoNotIn(List<String> values) {
            addCriterion("LC_NO not in", values, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoBetween(String value1, String value2) {
            addCriterion("LC_NO between", value1, value2, "lcNo");
            return (Criteria) this;
        }

        public Criteria andLcNoNotBetween(String value1, String value2) {
            addCriterion("LC_NO not between", value1, value2, "lcNo");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingIsNull() {
            addCriterion("PORT_OF_LOADING is null");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingIsNotNull() {
            addCriterion("PORT_OF_LOADING is not null");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingEqualTo(String value) {
            addCriterion("PORT_OF_LOADING =", value, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingNotEqualTo(String value) {
            addCriterion("PORT_OF_LOADING <>", value, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingGreaterThan(String value) {
            addCriterion("PORT_OF_LOADING >", value, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingGreaterThanOrEqualTo(String value) {
            addCriterion("PORT_OF_LOADING >=", value, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingLessThan(String value) {
            addCriterion("PORT_OF_LOADING <", value, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingLessThanOrEqualTo(String value) {
            addCriterion("PORT_OF_LOADING <=", value, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingLike(String value) {
            addCriterion("PORT_OF_LOADING like", value, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingNotLike(String value) {
            addCriterion("PORT_OF_LOADING not like", value, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingIn(List<String> values) {
            addCriterion("PORT_OF_LOADING in", values, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingNotIn(List<String> values) {
            addCriterion("PORT_OF_LOADING not in", values, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingBetween(String value1, String value2) {
            addCriterion("PORT_OF_LOADING between", value1, value2, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfLoadingNotBetween(String value1, String value2) {
            addCriterion("PORT_OF_LOADING not between", value1, value2, "portOfLoading");
            return (Criteria) this;
        }

        public Criteria andPortOfTransIsNull() {
            addCriterion("PORT_OF_TRANS is null");
            return (Criteria) this;
        }

        public Criteria andPortOfTransIsNotNull() {
            addCriterion("PORT_OF_TRANS is not null");
            return (Criteria) this;
        }

        public Criteria andPortOfTransEqualTo(String value) {
            addCriterion("PORT_OF_TRANS =", value, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfTransNotEqualTo(String value) {
            addCriterion("PORT_OF_TRANS <>", value, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfTransGreaterThan(String value) {
            addCriterion("PORT_OF_TRANS >", value, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfTransGreaterThanOrEqualTo(String value) {
            addCriterion("PORT_OF_TRANS >=", value, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfTransLessThan(String value) {
            addCriterion("PORT_OF_TRANS <", value, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfTransLessThanOrEqualTo(String value) {
            addCriterion("PORT_OF_TRANS <=", value, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfTransLike(String value) {
            addCriterion("PORT_OF_TRANS like", value, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfTransNotLike(String value) {
            addCriterion("PORT_OF_TRANS not like", value, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfTransIn(List<String> values) {
            addCriterion("PORT_OF_TRANS in", values, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfTransNotIn(List<String> values) {
            addCriterion("PORT_OF_TRANS not in", values, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfTransBetween(String value1, String value2) {
            addCriterion("PORT_OF_TRANS between", value1, value2, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfTransNotBetween(String value1, String value2) {
            addCriterion("PORT_OF_TRANS not between", value1, value2, "portOfTrans");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeIsNull() {
            addCriterion("PORT_OF_DISCHARGE is null");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeIsNotNull() {
            addCriterion("PORT_OF_DISCHARGE is not null");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeEqualTo(String value) {
            addCriterion("PORT_OF_DISCHARGE =", value, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeNotEqualTo(String value) {
            addCriterion("PORT_OF_DISCHARGE <>", value, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeGreaterThan(String value) {
            addCriterion("PORT_OF_DISCHARGE >", value, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeGreaterThanOrEqualTo(String value) {
            addCriterion("PORT_OF_DISCHARGE >=", value, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeLessThan(String value) {
            addCriterion("PORT_OF_DISCHARGE <", value, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeLessThanOrEqualTo(String value) {
            addCriterion("PORT_OF_DISCHARGE <=", value, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeLike(String value) {
            addCriterion("PORT_OF_DISCHARGE like", value, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeNotLike(String value) {
            addCriterion("PORT_OF_DISCHARGE not like", value, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeIn(List<String> values) {
            addCriterion("PORT_OF_DISCHARGE in", values, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeNotIn(List<String> values) {
            addCriterion("PORT_OF_DISCHARGE not in", values, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeBetween(String value1, String value2) {
            addCriterion("PORT_OF_DISCHARGE between", value1, value2, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andPortOfDischargeNotBetween(String value1, String value2) {
            addCriterion("PORT_OF_DISCHARGE not between", value1, value2, "portOfDischarge");
            return (Criteria) this;
        }

        public Criteria andLoadingDateIsNull() {
            addCriterion("LOADING_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLoadingDateIsNotNull() {
            addCriterion("LOADING_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLoadingDateEqualTo(Date value) {
            addCriterion("LOADING_DATE =", value, "loadingDate");
            return (Criteria) this;
        }

        public Criteria andLoadingDateNotEqualTo(Date value) {
            addCriterion("LOADING_DATE <>", value, "loadingDate");
            return (Criteria) this;
        }

        public Criteria andLoadingDateGreaterThan(Date value) {
            addCriterion("LOADING_DATE >", value, "loadingDate");
            return (Criteria) this;
        }

        public Criteria andLoadingDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LOADING_DATE >=", value, "loadingDate");
            return (Criteria) this;
        }

        public Criteria andLoadingDateLessThan(Date value) {
            addCriterion("LOADING_DATE <", value, "loadingDate");
            return (Criteria) this;
        }

        public Criteria andLoadingDateLessThanOrEqualTo(Date value) {
            addCriterion("LOADING_DATE <=", value, "loadingDate");
            return (Criteria) this;
        }

        public Criteria andLoadingDateIn(List<Date> values) {
            addCriterion("LOADING_DATE in", values, "loadingDate");
            return (Criteria) this;
        }

        public Criteria andLoadingDateNotIn(List<Date> values) {
            addCriterion("LOADING_DATE not in", values, "loadingDate");
            return (Criteria) this;
        }

        public Criteria andLoadingDateBetween(Date value1, Date value2) {
            addCriterion("LOADING_DATE between", value1, value2, "loadingDate");
            return (Criteria) this;
        }

        public Criteria andLoadingDateNotBetween(Date value1, Date value2) {
            addCriterion("LOADING_DATE not between", value1, value2, "loadingDate");
            return (Criteria) this;
        }

        public Criteria andLimitDateIsNull() {
            addCriterion("LIMIT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLimitDateIsNotNull() {
            addCriterion("LIMIT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLimitDateEqualTo(Date value) {
            addCriterion("LIMIT_DATE =", value, "limitDate");
            return (Criteria) this;
        }

        public Criteria andLimitDateNotEqualTo(Date value) {
            addCriterion("LIMIT_DATE <>", value, "limitDate");
            return (Criteria) this;
        }

        public Criteria andLimitDateGreaterThan(Date value) {
            addCriterion("LIMIT_DATE >", value, "limitDate");
            return (Criteria) this;
        }

        public Criteria andLimitDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LIMIT_DATE >=", value, "limitDate");
            return (Criteria) this;
        }

        public Criteria andLimitDateLessThan(Date value) {
            addCriterion("LIMIT_DATE <", value, "limitDate");
            return (Criteria) this;
        }

        public Criteria andLimitDateLessThanOrEqualTo(Date value) {
            addCriterion("LIMIT_DATE <=", value, "limitDate");
            return (Criteria) this;
        }

        public Criteria andLimitDateIn(List<Date> values) {
            addCriterion("LIMIT_DATE in", values, "limitDate");
            return (Criteria) this;
        }

        public Criteria andLimitDateNotIn(List<Date> values) {
            addCriterion("LIMIT_DATE not in", values, "limitDate");
            return (Criteria) this;
        }

        public Criteria andLimitDateBetween(Date value1, Date value2) {
            addCriterion("LIMIT_DATE between", value1, value2, "limitDate");
            return (Criteria) this;
        }

        public Criteria andLimitDateNotBetween(Date value1, Date value2) {
            addCriterion("LIMIT_DATE not between", value1, value2, "limitDate");
            return (Criteria) this;
        }

        public Criteria andIsBatchIsNull() {
            addCriterion("IS_BATCH is null");
            return (Criteria) this;
        }

        public Criteria andIsBatchIsNotNull() {
            addCriterion("IS_BATCH is not null");
            return (Criteria) this;
        }

        public Criteria andIsBatchEqualTo(String value) {
            addCriterion("IS_BATCH =", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchNotEqualTo(String value) {
            addCriterion("IS_BATCH <>", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchGreaterThan(String value) {
            addCriterion("IS_BATCH >", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchGreaterThanOrEqualTo(String value) {
            addCriterion("IS_BATCH >=", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchLessThan(String value) {
            addCriterion("IS_BATCH <", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchLessThanOrEqualTo(String value) {
            addCriterion("IS_BATCH <=", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchLike(String value) {
            addCriterion("IS_BATCH like", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchNotLike(String value) {
            addCriterion("IS_BATCH not like", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchIn(List<String> values) {
            addCriterion("IS_BATCH in", values, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchNotIn(List<String> values) {
            addCriterion("IS_BATCH not in", values, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchBetween(String value1, String value2) {
            addCriterion("IS_BATCH between", value1, value2, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchNotBetween(String value1, String value2) {
            addCriterion("IS_BATCH not between", value1, value2, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsTransIsNull() {
            addCriterion("IS_TRANS is null");
            return (Criteria) this;
        }

        public Criteria andIsTransIsNotNull() {
            addCriterion("IS_TRANS is not null");
            return (Criteria) this;
        }

        public Criteria andIsTransEqualTo(String value) {
            addCriterion("IS_TRANS =", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransNotEqualTo(String value) {
            addCriterion("IS_TRANS <>", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransGreaterThan(String value) {
            addCriterion("IS_TRANS >", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransGreaterThanOrEqualTo(String value) {
            addCriterion("IS_TRANS >=", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransLessThan(String value) {
            addCriterion("IS_TRANS <", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransLessThanOrEqualTo(String value) {
            addCriterion("IS_TRANS <=", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransLike(String value) {
            addCriterion("IS_TRANS like", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransNotLike(String value) {
            addCriterion("IS_TRANS not like", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransIn(List<String> values) {
            addCriterion("IS_TRANS in", values, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransNotIn(List<String> values) {
            addCriterion("IS_TRANS not in", values, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransBetween(String value1, String value2) {
            addCriterion("IS_TRANS between", value1, value2, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransNotBetween(String value1, String value2) {
            addCriterion("IS_TRANS not between", value1, value2, "isTrans");
            return (Criteria) this;
        }

        public Criteria andCopyNumIsNull() {
            addCriterion("COPY_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCopyNumIsNotNull() {
            addCriterion("COPY_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCopyNumEqualTo(String value) {
            addCriterion("COPY_NUM =", value, "copyNum");
            return (Criteria) this;
        }

        public Criteria andCopyNumNotEqualTo(String value) {
            addCriterion("COPY_NUM <>", value, "copyNum");
            return (Criteria) this;
        }

        public Criteria andCopyNumGreaterThan(String value) {
            addCriterion("COPY_NUM >", value, "copyNum");
            return (Criteria) this;
        }

        public Criteria andCopyNumGreaterThanOrEqualTo(String value) {
            addCriterion("COPY_NUM >=", value, "copyNum");
            return (Criteria) this;
        }

        public Criteria andCopyNumLessThan(String value) {
            addCriterion("COPY_NUM <", value, "copyNum");
            return (Criteria) this;
        }

        public Criteria andCopyNumLessThanOrEqualTo(String value) {
            addCriterion("COPY_NUM <=", value, "copyNum");
            return (Criteria) this;
        }

        public Criteria andCopyNumLike(String value) {
            addCriterion("COPY_NUM like", value, "copyNum");
            return (Criteria) this;
        }

        public Criteria andCopyNumNotLike(String value) {
            addCriterion("COPY_NUM not like", value, "copyNum");
            return (Criteria) this;
        }

        public Criteria andCopyNumIn(List<String> values) {
            addCriterion("COPY_NUM in", values, "copyNum");
            return (Criteria) this;
        }

        public Criteria andCopyNumNotIn(List<String> values) {
            addCriterion("COPY_NUM not in", values, "copyNum");
            return (Criteria) this;
        }

        public Criteria andCopyNumBetween(String value1, String value2) {
            addCriterion("COPY_NUM between", value1, value2, "copyNum");
            return (Criteria) this;
        }

        public Criteria andCopyNumNotBetween(String value1, String value2) {
            addCriterion("COPY_NUM not between", value1, value2, "copyNum");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionIsNull() {
            addCriterion("SPECIAL_CONDITION is null");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionIsNotNull() {
            addCriterion("SPECIAL_CONDITION is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionEqualTo(String value) {
            addCriterion("SPECIAL_CONDITION =", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionNotEqualTo(String value) {
            addCriterion("SPECIAL_CONDITION <>", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionGreaterThan(String value) {
            addCriterion("SPECIAL_CONDITION >", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionGreaterThanOrEqualTo(String value) {
            addCriterion("SPECIAL_CONDITION >=", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionLessThan(String value) {
            addCriterion("SPECIAL_CONDITION <", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionLessThanOrEqualTo(String value) {
            addCriterion("SPECIAL_CONDITION <=", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionLike(String value) {
            addCriterion("SPECIAL_CONDITION like", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionNotLike(String value) {
            addCriterion("SPECIAL_CONDITION not like", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionIn(List<String> values) {
            addCriterion("SPECIAL_CONDITION in", values, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionNotIn(List<String> values) {
            addCriterion("SPECIAL_CONDITION not in", values, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionBetween(String value1, String value2) {
            addCriterion("SPECIAL_CONDITION between", value1, value2, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionNotBetween(String value1, String value2) {
            addCriterion("SPECIAL_CONDITION not between", value1, value2, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("FREIGHT is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("FREIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(String value) {
            addCriterion("FREIGHT =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(String value) {
            addCriterion("FREIGHT <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(String value) {
            addCriterion("FREIGHT >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(String value) {
            addCriterion("FREIGHT >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(String value) {
            addCriterion("FREIGHT <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(String value) {
            addCriterion("FREIGHT <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLike(String value) {
            addCriterion("FREIGHT like", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotLike(String value) {
            addCriterion("FREIGHT not like", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<String> values) {
            addCriterion("FREIGHT in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<String> values) {
            addCriterion("FREIGHT not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(String value1, String value2) {
            addCriterion("FREIGHT between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(String value1, String value2) {
            addCriterion("FREIGHT not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andCheckByIsNull() {
            addCriterion("CHECK_BY is null");
            return (Criteria) this;
        }

        public Criteria andCheckByIsNotNull() {
            addCriterion("CHECK_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCheckByEqualTo(String value) {
            addCriterion("CHECK_BY =", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByNotEqualTo(String value) {
            addCriterion("CHECK_BY <>", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByGreaterThan(String value) {
            addCriterion("CHECK_BY >", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_BY >=", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByLessThan(String value) {
            addCriterion("CHECK_BY <", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByLessThanOrEqualTo(String value) {
            addCriterion("CHECK_BY <=", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByLike(String value) {
            addCriterion("CHECK_BY like", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByNotLike(String value) {
            addCriterion("CHECK_BY not like", value, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByIn(List<String> values) {
            addCriterion("CHECK_BY in", values, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByNotIn(List<String> values) {
            addCriterion("CHECK_BY not in", values, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByBetween(String value1, String value2) {
            addCriterion("CHECK_BY between", value1, value2, "checkBy");
            return (Criteria) this;
        }

        public Criteria andCheckByNotBetween(String value1, String value2) {
            addCriterion("CHECK_BY not between", value1, value2, "checkBy");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("CREATE_BY =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("CREATE_BY <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("CREATE_BY >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_BY >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("CREATE_BY <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("CREATE_BY <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("CREATE_BY like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("CREATE_BY not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("CREATE_BY in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("CREATE_BY not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("CREATE_BY between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("CREATE_BY not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIsNull() {
            addCriterion("CREATE_DEPT is null");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIsNotNull() {
            addCriterion("CREATE_DEPT is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDeptEqualTo(String value) {
            addCriterion("CREATE_DEPT =", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotEqualTo(String value) {
            addCriterion("CREATE_DEPT <>", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptGreaterThan(String value) {
            addCriterion("CREATE_DEPT >", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_DEPT >=", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptLessThan(String value) {
            addCriterion("CREATE_DEPT <", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptLessThanOrEqualTo(String value) {
            addCriterion("CREATE_DEPT <=", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptLike(String value) {
            addCriterion("CREATE_DEPT like", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotLike(String value) {
            addCriterion("CREATE_DEPT not like", value, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptIn(List<String> values) {
            addCriterion("CREATE_DEPT in", values, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotIn(List<String> values) {
            addCriterion("CREATE_DEPT not in", values, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptBetween(String value1, String value2) {
            addCriterion("CREATE_DEPT between", value1, value2, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateDeptNotBetween(String value1, String value2) {
            addCriterion("CREATE_DEPT not between", value1, value2, "createDept");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}