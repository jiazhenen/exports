package cn.itcast.domain.cargo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PackingExample implements Serializable {
    

        protected String orderByClause;

        protected boolean distinct;

        protected List<cn.itcast.domain.cargo.PackingExample.Criteria> oredCriteria;

        public PackingExample() {
            oredCriteria = new ArrayList<cn.itcast.domain.cargo.PackingExample.Criteria>();
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

        public List<cn.itcast.domain.cargo.PackingExample.Criteria> getOredCriteria() {
            return oredCriteria;
        }

        public void or(cn.itcast.domain.cargo.PackingExample.Criteria criteria) {
            oredCriteria.add(criteria);
        }

        public cn.itcast.domain.cargo.PackingExample.Criteria or() {
            cn.itcast.domain.cargo.PackingExample.Criteria criteria = createCriteriaInternal();
            oredCriteria.add(criteria);
            return criteria;
        }

        public cn.itcast.domain.cargo.PackingExample.Criteria createCriteria() {
            cn.itcast.domain.cargo.PackingExample.Criteria criteria = createCriteriaInternal();
            if (oredCriteria.size() == 0) {
                oredCriteria.add(criteria);
            }
            return criteria;
        }

        protected cn.itcast.domain.cargo.PackingExample.Criteria createCriteriaInternal() {
            cn.itcast.domain.cargo.PackingExample.Criteria criteria = new cn.itcast.domain.cargo.PackingExample.Criteria();
            return criteria;
        }

        public void clear() {
            oredCriteria.clear();
            orderByClause = null;
            distinct = false;
        }

        protected abstract static class GeneratedCriteria implements Serializable {
            protected List<cn.itcast.domain.cargo.PackingExample.Criterion> criteria;

            protected GeneratedCriteria() {
                super();
                criteria = new ArrayList<cn.itcast.domain.cargo.PackingExample.Criterion>();
            }

            public boolean isValid() {
                return criteria.size() > 0;
            }

            public List<cn.itcast.domain.cargo.PackingExample.Criterion> getAllCriteria() {
                return criteria;
            }

            public List<cn.itcast.domain.cargo.PackingExample.Criterion> getCriteria() {
                return criteria;
            }

            protected void addCriterion(String condition) {
                if (condition == null) {
                    throw new RuntimeException("Value for condition cannot be null");
                }
                criteria.add(new cn.itcast.domain.cargo.PackingExample.Criterion(condition));
            }

            protected void addCriterion(String condition, Object value, String property) {
                if (value == null) {
                    throw new RuntimeException("Value for " + property + " cannot be null");
                }
                criteria.add(new cn.itcast.domain.cargo.PackingExample.Criterion(condition, value));
            }

            protected void addCriterion(String condition, Object value1, Object value2, String property) {
                if (value1 == null || value2 == null) {
                    throw new RuntimeException("Between values for " + property + " cannot be null");
                }
                criteria.add(new cn.itcast.domain.cargo.PackingExample.Criterion(condition, value1, value2));
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdIsNull() {
                addCriterion("SHIPPING_ORDER_ID is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdIsNotNull() {
                addCriterion("SHIPPING_ORDER_ID is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdEqualTo(String value) {
                addCriterion("SHIPPING_ORDER_ID =", value, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdNotEqualTo(String value) {
                addCriterion("SHIPPING_ORDER_ID <>", value, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdGreaterThan(String value) {
                addCriterion("SHIPPING_ORDER_ID >", value, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdGreaterThanOrEqualTo(String value) {
                addCriterion("SHIPPING_ORDER_ID >=", value, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdLessThan(String value) {
                addCriterion("SHIPPING_ORDER_ID <", value, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdLessThanOrEqualTo(String value) {
                addCriterion("SHIPPING_ORDER_ID <=", value, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdLike(String value) {
                addCriterion("SHIPPING_ORDER_ID like", value, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdNotLike(String value) {
                addCriterion("SHIPPING_ORDER_ID not like", value, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdIn(List<String> values) {
                addCriterion("SHIPPING_ORDER_ID in", values, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdNotIn(List<String> values) {
                addCriterion("SHIPPING_ORDER_ID not in", values, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdBetween(String value1, String value2) {
                addCriterion("SHIPPING_ORDER_ID between", value1, value2, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShippingOrderIdNotBetween(String value1, String value2) {
                addCriterion("SHIPPING_ORDER_ID not between", value1, value2, "shippingOrderId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeIsNull() {
                addCriterion("ORDER_TYPE is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeIsNotNull() {
                addCriterion("ORDER_TYPE is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeEqualTo(String value) {
                addCriterion("ORDER_TYPE =", value, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeNotEqualTo(String value) {
                addCriterion("ORDER_TYPE <>", value, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeGreaterThan(String value) {
                addCriterion("ORDER_TYPE >", value, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
                addCriterion("ORDER_TYPE >=", value, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeLessThan(String value) {
                addCriterion("ORDER_TYPE <", value, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeLessThanOrEqualTo(String value) {
                addCriterion("ORDER_TYPE <=", value, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeLike(String value) {
                addCriterion("ORDER_TYPE like", value, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeNotLike(String value) {
                addCriterion("ORDER_TYPE not like", value, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeIn(List<String> values) {
                addCriterion("ORDER_TYPE in", values, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeNotIn(List<String> values) {
                addCriterion("ORDER_TYPE not in", values, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeBetween(String value1, String value2) {
                addCriterion("ORDER_TYPE between", value1, value2, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andOrderTypeNotBetween(String value1, String value2) {
                addCriterion("ORDER_TYPE not between", value1, value2, "orderType");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperIsNull() {
                addCriterion("SHIPPER is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperIsNotNull() {
                addCriterion("SHIPPER is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperEqualTo(String value) {
                addCriterion("SHIPPER =", value, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperNotEqualTo(String value) {
                addCriterion("SHIPPER <>", value, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperGreaterThan(String value) {
                addCriterion("SHIPPER >", value, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperGreaterThanOrEqualTo(String value) {
                addCriterion("SHIPPER >=", value, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperLessThan(String value) {
                addCriterion("SHIPPER <", value, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperLessThanOrEqualTo(String value) {
                addCriterion("SHIPPER <=", value, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperLike(String value) {
                addCriterion("SHIPPER like", value, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperNotLike(String value) {
                addCriterion("SHIPPER not like", value, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperIn(List<String> values) {
                addCriterion("SHIPPER in", values, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperNotIn(List<String> values) {
                addCriterion("SHIPPER not in", values, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperBetween(String value1, String value2) {
                addCriterion("SHIPPER between", value1, value2, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andShipperNotBetween(String value1, String value2) {
                addCriterion("SHIPPER not between", value1, value2, "shipper");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeIsNull() {
                addCriterion("CONSIGNEE is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeIsNotNull() {
                addCriterion("CONSIGNEE is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeEqualTo(String value) {
                addCriterion("CONSIGNEE =", value, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeNotEqualTo(String value) {
                addCriterion("CONSIGNEE <>", value, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeGreaterThan(String value) {
                addCriterion("CONSIGNEE >", value, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeGreaterThanOrEqualTo(String value) {
                addCriterion("CONSIGNEE >=", value, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeLessThan(String value) {
                addCriterion("CONSIGNEE <", value, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeLessThanOrEqualTo(String value) {
                addCriterion("CONSIGNEE <=", value, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeLike(String value) {
                addCriterion("CONSIGNEE like", value, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeNotLike(String value) {
                addCriterion("CONSIGNEE not like", value, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeIn(List<String> values) {
                addCriterion("CONSIGNEE in", values, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeNotIn(List<String> values) {
                addCriterion("CONSIGNEE not in", values, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeBetween(String value1, String value2) {
                addCriterion("CONSIGNEE between", value1, value2, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andConsigneeNotBetween(String value1, String value2) {
                addCriterion("CONSIGNEE not between", value1, value2, "consignee");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyIsNull() {
                addCriterion("NOTIFY_PARTY is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyIsNotNull() {
                addCriterion("NOTIFY_PARTY is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyEqualTo(String value) {
                addCriterion("NOTIFY_PARTY =", value, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyNotEqualTo(String value) {
                addCriterion("NOTIFY_PARTY <>", value, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyGreaterThan(String value) {
                addCriterion("NOTIFY_PARTY >", value, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyGreaterThanOrEqualTo(String value) {
                addCriterion("NOTIFY_PARTY >=", value, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyLessThan(String value) {
                addCriterion("NOTIFY_PARTY <", value, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyLessThanOrEqualTo(String value) {
                addCriterion("NOTIFY_PARTY <=", value, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyLike(String value) {
                addCriterion("NOTIFY_PARTY like", value, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyNotLike(String value) {
                addCriterion("NOTIFY_PARTY not like", value, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyIn(List<String> values) {
                addCriterion("NOTIFY_PARTY in", values, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyNotIn(List<String> values) {
                addCriterion("NOTIFY_PARTY not in", values, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyBetween(String value1, String value2) {
                addCriterion("NOTIFY_PARTY between", value1, value2, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andNotifyPartyNotBetween(String value1, String value2) {
                addCriterion("NOTIFY_PARTY not between", value1, value2, "notifyParty");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoIsNull() {
                addCriterion("LC_NO is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoIsNotNull() {
                addCriterion("LC_NO is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoEqualTo(String value) {
                addCriterion("LC_NO =", value, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoNotEqualTo(String value) {
                addCriterion("LC_NO <>", value, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoGreaterThan(String value) {
                addCriterion("LC_NO >", value, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoGreaterThanOrEqualTo(String value) {
                addCriterion("LC_NO >=", value, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoLessThan(String value) {
                addCriterion("LC_NO <", value, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoLessThanOrEqualTo(String value) {
                addCriterion("LC_NO <=", value, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoLike(String value) {
                addCriterion("LC_NO like", value, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoNotLike(String value) {
                addCriterion("LC_NO not like", value, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoIn(List<String> values) {
                addCriterion("LC_NO in", values, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoNotIn(List<String> values) {
                addCriterion("LC_NO not in", values, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoBetween(String value1, String value2) {
                addCriterion("LC_NO between", value1, value2, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLcNoNotBetween(String value1, String value2) {
                addCriterion("LC_NO not between", value1, value2, "lcNo");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingIsNull() {
                addCriterion("PORT_OF_LOADING is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingIsNotNull() {
                addCriterion("PORT_OF_LOADING is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingEqualTo(String value) {
                addCriterion("PORT_OF_LOADING =", value, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingNotEqualTo(String value) {
                addCriterion("PORT_OF_LOADING <>", value, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingGreaterThan(String value) {
                addCriterion("PORT_OF_LOADING >", value, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingGreaterThanOrEqualTo(String value) {
                addCriterion("PORT_OF_LOADING >=", value, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingLessThan(String value) {
                addCriterion("PORT_OF_LOADING <", value, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingLessThanOrEqualTo(String value) {
                addCriterion("PORT_OF_LOADING <=", value, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingLike(String value) {
                addCriterion("PORT_OF_LOADING like", value, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingNotLike(String value) {
                addCriterion("PORT_OF_LOADING not like", value, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingIn(List<String> values) {
                addCriterion("PORT_OF_LOADING in", values, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingNotIn(List<String> values) {
                addCriterion("PORT_OF_LOADING not in", values, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingBetween(String value1, String value2) {
                addCriterion("PORT_OF_LOADING between", value1, value2, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfLoadingNotBetween(String value1, String value2) {
                addCriterion("PORT_OF_LOADING not between", value1, value2, "portOfLoading");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransIsNull() {
                addCriterion("PORT_OF_TRANS is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransIsNotNull() {
                addCriterion("PORT_OF_TRANS is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransEqualTo(String value) {
                addCriterion("PORT_OF_TRANS =", value, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransNotEqualTo(String value) {
                addCriterion("PORT_OF_TRANS <>", value, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransGreaterThan(String value) {
                addCriterion("PORT_OF_TRANS >", value, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransGreaterThanOrEqualTo(String value) {
                addCriterion("PORT_OF_TRANS >=", value, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransLessThan(String value) {
                addCriterion("PORT_OF_TRANS <", value, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransLessThanOrEqualTo(String value) {
                addCriterion("PORT_OF_TRANS <=", value, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransLike(String value) {
                addCriterion("PORT_OF_TRANS like", value, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransNotLike(String value) {
                addCriterion("PORT_OF_TRANS not like", value, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransIn(List<String> values) {
                addCriterion("PORT_OF_TRANS in", values, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransNotIn(List<String> values) {
                addCriterion("PORT_OF_TRANS not in", values, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransBetween(String value1, String value2) {
                addCriterion("PORT_OF_TRANS between", value1, value2, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfTransNotBetween(String value1, String value2) {
                addCriterion("PORT_OF_TRANS not between", value1, value2, "portOfTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeIsNull() {
                addCriterion("PORT_OF_DISCHARGE is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeIsNotNull() {
                addCriterion("PORT_OF_DISCHARGE is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeEqualTo(String value) {
                addCriterion("PORT_OF_DISCHARGE =", value, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeNotEqualTo(String value) {
                addCriterion("PORT_OF_DISCHARGE <>", value, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeGreaterThan(String value) {
                addCriterion("PORT_OF_DISCHARGE >", value, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeGreaterThanOrEqualTo(String value) {
                addCriterion("PORT_OF_DISCHARGE >=", value, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeLessThan(String value) {
                addCriterion("PORT_OF_DISCHARGE <", value, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeLessThanOrEqualTo(String value) {
                addCriterion("PORT_OF_DISCHARGE <=", value, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeLike(String value) {
                addCriterion("PORT_OF_DISCHARGE like", value, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeNotLike(String value) {
                addCriterion("PORT_OF_DISCHARGE not like", value, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeIn(List<String> values) {
                addCriterion("PORT_OF_DISCHARGE in", values, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeNotIn(List<String> values) {
                addCriterion("PORT_OF_DISCHARGE not in", values, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeBetween(String value1, String value2) {
                addCriterion("PORT_OF_DISCHARGE between", value1, value2, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andPortOfDischargeNotBetween(String value1, String value2) {
                addCriterion("PORT_OF_DISCHARGE not between", value1, value2, "portOfDischarge");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateIsNull() {
                addCriterion("LOADING_DATE is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateIsNotNull() {
                addCriterion("LOADING_DATE is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateEqualTo(Date value) {
                addCriterion("LOADING_DATE =", value, "loadingDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateNotEqualTo(Date value) {
                addCriterion("LOADING_DATE <>", value, "loadingDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateGreaterThan(Date value) {
                addCriterion("LOADING_DATE >", value, "loadingDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateGreaterThanOrEqualTo(Date value) {
                addCriterion("LOADING_DATE >=", value, "loadingDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateLessThan(Date value) {
                addCriterion("LOADING_DATE <", value, "loadingDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateLessThanOrEqualTo(Date value) {
                addCriterion("LOADING_DATE <=", value, "loadingDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateIn(List<Date> values) {
                addCriterion("LOADING_DATE in", values, "loadingDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateNotIn(List<Date> values) {
                addCriterion("LOADING_DATE not in", values, "loadingDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateBetween(Date value1, Date value2) {
                addCriterion("LOADING_DATE between", value1, value2, "loadingDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLoadingDateNotBetween(Date value1, Date value2) {
                addCriterion("LOADING_DATE not between", value1, value2, "loadingDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateIsNull() {
                addCriterion("LIMIT_DATE is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateIsNotNull() {
                addCriterion("LIMIT_DATE is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateEqualTo(Date value) {
                addCriterion("LIMIT_DATE =", value, "limitDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateNotEqualTo(Date value) {
                addCriterion("LIMIT_DATE <>", value, "limitDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateGreaterThan(Date value) {
                addCriterion("LIMIT_DATE >", value, "limitDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateGreaterThanOrEqualTo(Date value) {
                addCriterion("LIMIT_DATE >=", value, "limitDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateLessThan(Date value) {
                addCriterion("LIMIT_DATE <", value, "limitDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateLessThanOrEqualTo(Date value) {
                addCriterion("LIMIT_DATE <=", value, "limitDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateIn(List<Date> values) {
                addCriterion("LIMIT_DATE in", values, "limitDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateNotIn(List<Date> values) {
                addCriterion("LIMIT_DATE not in", values, "limitDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateBetween(Date value1, Date value2) {
                addCriterion("LIMIT_DATE between", value1, value2, "limitDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andLimitDateNotBetween(Date value1, Date value2) {
                addCriterion("LIMIT_DATE not between", value1, value2, "limitDate");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchIsNull() {
                addCriterion("IS_BATCH is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchIsNotNull() {
                addCriterion("IS_BATCH is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchEqualTo(String value) {
                addCriterion("IS_BATCH =", value, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchNotEqualTo(String value) {
                addCriterion("IS_BATCH <>", value, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchGreaterThan(String value) {
                addCriterion("IS_BATCH >", value, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchGreaterThanOrEqualTo(String value) {
                addCriterion("IS_BATCH >=", value, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchLessThan(String value) {
                addCriterion("IS_BATCH <", value, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchLessThanOrEqualTo(String value) {
                addCriterion("IS_BATCH <=", value, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchLike(String value) {
                addCriterion("IS_BATCH like", value, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchNotLike(String value) {
                addCriterion("IS_BATCH not like", value, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchIn(List<String> values) {
                addCriterion("IS_BATCH in", values, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchNotIn(List<String> values) {
                addCriterion("IS_BATCH not in", values, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchBetween(String value1, String value2) {
                addCriterion("IS_BATCH between", value1, value2, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsBatchNotBetween(String value1, String value2) {
                addCriterion("IS_BATCH not between", value1, value2, "isBatch");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransIsNull() {
                addCriterion("IS_TRANS is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransIsNotNull() {
                addCriterion("IS_TRANS is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransEqualTo(String value) {
                addCriterion("IS_TRANS =", value, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransNotEqualTo(String value) {
                addCriterion("IS_TRANS <>", value, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransGreaterThan(String value) {
                addCriterion("IS_TRANS >", value, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransGreaterThanOrEqualTo(String value) {
                addCriterion("IS_TRANS >=", value, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransLessThan(String value) {
                addCriterion("IS_TRANS <", value, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransLessThanOrEqualTo(String value) {
                addCriterion("IS_TRANS <=", value, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransLike(String value) {
                addCriterion("IS_TRANS like", value, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransNotLike(String value) {
                addCriterion("IS_TRANS not like", value, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransIn(List<String> values) {
                addCriterion("IS_TRANS in", values, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransNotIn(List<String> values) {
                addCriterion("IS_TRANS not in", values, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransBetween(String value1, String value2) {
                addCriterion("IS_TRANS between", value1, value2, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andIsTransNotBetween(String value1, String value2) {
                addCriterion("IS_TRANS not between", value1, value2, "isTrans");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumIsNull() {
                addCriterion("COPY_NUM is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumIsNotNull() {
                addCriterion("COPY_NUM is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumEqualTo(String value) {
                addCriterion("COPY_NUM =", value, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumNotEqualTo(String value) {
                addCriterion("COPY_NUM <>", value, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumGreaterThan(String value) {
                addCriterion("COPY_NUM >", value, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumGreaterThanOrEqualTo(String value) {
                addCriterion("COPY_NUM >=", value, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumLessThan(String value) {
                addCriterion("COPY_NUM <", value, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumLessThanOrEqualTo(String value) {
                addCriterion("COPY_NUM <=", value, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumLike(String value) {
                addCriterion("COPY_NUM like", value, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumNotLike(String value) {
                addCriterion("COPY_NUM not like", value, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumIn(List<String> values) {
                addCriterion("COPY_NUM in", values, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumNotIn(List<String> values) {
                addCriterion("COPY_NUM not in", values, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumBetween(String value1, String value2) {
                addCriterion("COPY_NUM between", value1, value2, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCopyNumNotBetween(String value1, String value2) {
                addCriterion("COPY_NUM not between", value1, value2, "copyNum");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkIsNull() {
                addCriterion("REMARK is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkIsNotNull() {
                addCriterion("REMARK is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkEqualTo(String value) {
                addCriterion("REMARK =", value, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkNotEqualTo(String value) {
                addCriterion("REMARK <>", value, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkGreaterThan(String value) {
                addCriterion("REMARK >", value, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
                addCriterion("REMARK >=", value, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkLessThan(String value) {
                addCriterion("REMARK <", value, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkLessThanOrEqualTo(String value) {
                addCriterion("REMARK <=", value, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkLike(String value) {
                addCriterion("REMARK like", value, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkNotLike(String value) {
                addCriterion("REMARK not like", value, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkIn(List<String> values) {
                addCriterion("REMARK in", values, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkNotIn(List<String> values) {
                addCriterion("REMARK not in", values, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkBetween(String value1, String value2) {
                addCriterion("REMARK between", value1, value2, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andRemarkNotBetween(String value1, String value2) {
                addCriterion("REMARK not between", value1, value2, "remark");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionIsNull() {
                addCriterion("SPECIAL_CONDITION is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionIsNotNull() {
                addCriterion("SPECIAL_CONDITION is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionEqualTo(String value) {
                addCriterion("SPECIAL_CONDITION =", value, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionNotEqualTo(String value) {
                addCriterion("SPECIAL_CONDITION <>", value, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionGreaterThan(String value) {
                addCriterion("SPECIAL_CONDITION >", value, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionGreaterThanOrEqualTo(String value) {
                addCriterion("SPECIAL_CONDITION >=", value, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionLessThan(String value) {
                addCriterion("SPECIAL_CONDITION <", value, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionLessThanOrEqualTo(String value) {
                addCriterion("SPECIAL_CONDITION <=", value, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionLike(String value) {
                addCriterion("SPECIAL_CONDITION like", value, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionNotLike(String value) {
                addCriterion("SPECIAL_CONDITION not like", value, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionIn(List<String> values) {
                addCriterion("SPECIAL_CONDITION in", values, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionNotIn(List<String> values) {
                addCriterion("SPECIAL_CONDITION not in", values, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionBetween(String value1, String value2) {
                addCriterion("SPECIAL_CONDITION between", value1, value2, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andSpecialConditionNotBetween(String value1, String value2) {
                addCriterion("SPECIAL_CONDITION not between", value1, value2, "specialCondition");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightIsNull() {
                addCriterion("FREIGHT is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightIsNotNull() {
                addCriterion("FREIGHT is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightEqualTo(String value) {
                addCriterion("FREIGHT =", value, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightNotEqualTo(String value) {
                addCriterion("FREIGHT <>", value, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightGreaterThan(String value) {
                addCriterion("FREIGHT >", value, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightGreaterThanOrEqualTo(String value) {
                addCriterion("FREIGHT >=", value, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightLessThan(String value) {
                addCriterion("FREIGHT <", value, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightLessThanOrEqualTo(String value) {
                addCriterion("FREIGHT <=", value, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightLike(String value) {
                addCriterion("FREIGHT like", value, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightNotLike(String value) {
                addCriterion("FREIGHT not like", value, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightIn(List<String> values) {
                addCriterion("FREIGHT in", values, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightNotIn(List<String> values) {
                addCriterion("FREIGHT not in", values, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightBetween(String value1, String value2) {
                addCriterion("FREIGHT between", value1, value2, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andFreightNotBetween(String value1, String value2) {
                addCriterion("FREIGHT not between", value1, value2, "freight");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByIsNull() {
                addCriterion("CHECK_BY is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByIsNotNull() {
                addCriterion("CHECK_BY is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByEqualTo(String value) {
                addCriterion("CHECK_BY =", value, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByNotEqualTo(String value) {
                addCriterion("CHECK_BY <>", value, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByGreaterThan(String value) {
                addCriterion("CHECK_BY >", value, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByGreaterThanOrEqualTo(String value) {
                addCriterion("CHECK_BY >=", value, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByLessThan(String value) {
                addCriterion("CHECK_BY <", value, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByLessThanOrEqualTo(String value) {
                addCriterion("CHECK_BY <=", value, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByLike(String value) {
                addCriterion("CHECK_BY like", value, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByNotLike(String value) {
                addCriterion("CHECK_BY not like", value, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByIn(List<String> values) {
                addCriterion("CHECK_BY in", values, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByNotIn(List<String> values) {
                addCriterion("CHECK_BY not in", values, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByBetween(String value1, String value2) {
                addCriterion("CHECK_BY between", value1, value2, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCheckByNotBetween(String value1, String value2) {
                addCriterion("CHECK_BY not between", value1, value2, "checkBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateIsNull() {
                addCriterion("STATE is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateIsNotNull() {
                addCriterion("STATE is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateEqualTo(Integer value) {
                addCriterion("STATE =", value, "state");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateNotEqualTo(Integer value) {
                addCriterion("STATE <>", value, "state");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateGreaterThan(Integer value) {
                addCriterion("STATE >", value, "state");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateGreaterThanOrEqualTo(Integer value) {
                addCriterion("STATE >=", value, "state");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateLessThan(Integer value) {
                addCriterion("STATE <", value, "state");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateLessThanOrEqualTo(Integer value) {
                addCriterion("STATE <=", value, "state");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateIn(List<Integer> values) {
                addCriterion("STATE in", values, "state");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateNotIn(List<Integer> values) {
                addCriterion("STATE not in", values, "state");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateBetween(Integer value1, Integer value2) {
                addCriterion("STATE between", value1, value2, "state");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andStateNotBetween(Integer value1, Integer value2) {
                addCriterion("STATE not between", value1, value2, "state");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByIsNull() {
                addCriterion("CREATE_BY is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByIsNotNull() {
                addCriterion("CREATE_BY is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByEqualTo(String value) {
                addCriterion("CREATE_BY =", value, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByNotEqualTo(String value) {
                addCriterion("CREATE_BY <>", value, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByGreaterThan(String value) {
                addCriterion("CREATE_BY >", value, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByGreaterThanOrEqualTo(String value) {
                addCriterion("CREATE_BY >=", value, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByLessThan(String value) {
                addCriterion("CREATE_BY <", value, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByLessThanOrEqualTo(String value) {
                addCriterion("CREATE_BY <=", value, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByLike(String value) {
                addCriterion("CREATE_BY like", value, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByNotLike(String value) {
                addCriterion("CREATE_BY not like", value, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByIn(List<String> values) {
                addCriterion("CREATE_BY in", values, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByNotIn(List<String> values) {
                addCriterion("CREATE_BY not in", values, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByBetween(String value1, String value2) {
                addCriterion("CREATE_BY between", value1, value2, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateByNotBetween(String value1, String value2) {
                addCriterion("CREATE_BY not between", value1, value2, "createBy");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptIsNull() {
                addCriterion("CREATE_DEPT is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptIsNotNull() {
                addCriterion("CREATE_DEPT is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptEqualTo(String value) {
                addCriterion("CREATE_DEPT =", value, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptNotEqualTo(String value) {
                addCriterion("CREATE_DEPT <>", value, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptGreaterThan(String value) {
                addCriterion("CREATE_DEPT >", value, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptGreaterThanOrEqualTo(String value) {
                addCriterion("CREATE_DEPT >=", value, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptLessThan(String value) {
                addCriterion("CREATE_DEPT <", value, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptLessThanOrEqualTo(String value) {
                addCriterion("CREATE_DEPT <=", value, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptLike(String value) {
                addCriterion("CREATE_DEPT like", value, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptNotLike(String value) {
                addCriterion("CREATE_DEPT not like", value, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptIn(List<String> values) {
                addCriterion("CREATE_DEPT in", values, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptNotIn(List<String> values) {
                addCriterion("CREATE_DEPT not in", values, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptBetween(String value1, String value2) {
                addCriterion("CREATE_DEPT between", value1, value2, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateDeptNotBetween(String value1, String value2) {
                addCriterion("CREATE_DEPT not between", value1, value2, "createDept");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeIsNull() {
                addCriterion("CREATE_TIME is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeIsNotNull() {
                addCriterion("CREATE_TIME is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeEqualTo(Date value) {
                addCriterion("CREATE_TIME =", value, "createTime");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeNotEqualTo(Date value) {
                addCriterion("CREATE_TIME <>", value, "createTime");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeGreaterThan(Date value) {
                addCriterion("CREATE_TIME >", value, "createTime");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
                addCriterion("CREATE_TIME >=", value, "createTime");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeLessThan(Date value) {
                addCriterion("CREATE_TIME <", value, "createTime");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
                addCriterion("CREATE_TIME <=", value, "createTime");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeIn(List<Date> values) {
                addCriterion("CREATE_TIME in", values, "createTime");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeNotIn(List<Date> values) {
                addCriterion("CREATE_TIME not in", values, "createTime");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
                addCriterion("CREATE_TIME between", value1, value2, "createTime");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
                addCriterion("CREATE_TIME not between", value1, value2, "createTime");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdIsNull() {
                addCriterion("company_id is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdIsNotNull() {
                addCriterion("company_id is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdEqualTo(String value) {
                addCriterion("company_id =", value, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdNotEqualTo(String value) {
                addCriterion("company_id <>", value, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdGreaterThan(String value) {
                addCriterion("company_id >", value, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
                addCriterion("company_id >=", value, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdLessThan(String value) {
                addCriterion("company_id <", value, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdLessThanOrEqualTo(String value) {
                addCriterion("company_id <=", value, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdLike(String value) {
                addCriterion("company_id like", value, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdNotLike(String value) {
                addCriterion("company_id not like", value, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdIn(List<String> values) {
                addCriterion("company_id in", values, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdNotIn(List<String> values) {
                addCriterion("company_id not in", values, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdBetween(String value1, String value2) {
                addCriterion("company_id between", value1, value2, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyIdNotBetween(String value1, String value2) {
                addCriterion("company_id not between", value1, value2, "companyId");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameIsNull() {
                addCriterion("company_name is null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameIsNotNull() {
                addCriterion("company_name is not null");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameEqualTo(String value) {
                addCriterion("company_name =", value, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameNotEqualTo(String value) {
                addCriterion("company_name <>", value, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameGreaterThan(String value) {
                addCriterion("company_name >", value, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
                addCriterion("company_name >=", value, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameLessThan(String value) {
                addCriterion("company_name <", value, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameLessThanOrEqualTo(String value) {
                addCriterion("company_name <=", value, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameLike(String value) {
                addCriterion("company_name like", value, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameNotLike(String value) {
                addCriterion("company_name not like", value, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameIn(List<String> values) {
                addCriterion("company_name in", values, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameNotIn(List<String> values) {
                addCriterion("company_name not in", values, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameBetween(String value1, String value2) {
                addCriterion("company_name between", value1, value2, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }

            public cn.itcast.domain.cargo.PackingExample.Criteria andCompanyNameNotBetween(String value1, String value2) {
                addCriterion("company_name not between", value1, value2, "companyName");
                return (cn.itcast.domain.cargo.PackingExample.Criteria) this;
            }
        }

        public static class Criteria extends cn.itcast.domain.cargo.PackingExample.GeneratedCriteria implements Serializable {

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
