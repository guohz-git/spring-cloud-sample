#spring-cloud-sample


ognl  -x  3 '@com.pamirs.pradar.maxplanck.module.agent.shared.service.CutoffConfiguration@loadedClasses'


ognl  -x  3 '@com.pamirs.pradar.maxplanck.module.agent.shared.service.CutoffConfiguration@loadedConfigs'


trace com.pamirs.pradar.maxplanck.module.agent.shared.service.CutoffConfiguration getConfigInvoker -n 5 '1==1'
