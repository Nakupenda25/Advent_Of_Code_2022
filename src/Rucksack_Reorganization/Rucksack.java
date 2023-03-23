package Rucksack_Reorganization;
import java.util.HashSet;

public class Rucksack {

    static final String abcABC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static int getPriority(char duplicateChar){
        return abcABC.indexOf(duplicateChar) + 1;
    }

    static int getPriorityOfCommonItem(String input){
        int priority = 0;
        HashSet<Character> firstCompartment = new HashSet<>();

        // Add all item types in the first compartment to a HashSet
        for (int counter = 0; counter < input.length() / 2; counter++){
            firstCompartment.add(input.charAt(counter));
        }

        // Iterate over the second compartment and check for a common item type
        for (int i = input.length() / 2; i < input.length(); i++){
            char c = input.charAt(i);
            if (firstCompartment.contains(c)){
                priority += getPriority(c);
                break;
            }
        }

        return priority;
    }

    static HashSet<Character> getCommonItems(String input){
        HashSet<Character> commonItems = new HashSet<>();

        for (int counter = 0; counter < input.length(); counter++){
            commonItems.add(input.charAt(counter));
        }

        return commonItems;
    }

    public static void main(String[] args) {

        String[] listOfBackpacks = input.split("\n");

        int sumOfPriorities = 0;
        for (String string : listOfBackpacks){
            sumOfPriorities += getPriorityOfCommonItem(string);
        }

        System.out.println(sumOfPriorities);
        sumOfPriorities = 0;

        int groupCounter = 0;
        HashSet<Character> commonItems1 = new HashSet<>();
        HashSet<Character> commonItems2 = new HashSet<>();
        HashSet<Character> commonItems3 = new HashSet<>();

        for (String string : listOfBackpacks){
            if (groupCounter == 0){
                commonItems1 = getCommonItems(string);
                groupCounter++;

            }else if (groupCounter == 1){
                commonItems2 = getCommonItems(string);
                groupCounter++;

            } else if (groupCounter == 2) {
                commonItems3 = getCommonItems(string);

                for (Character character : commonItems1) {
                    if (commonItems2.contains(character) && commonItems3.contains(character)){
                        sumOfPriorities += getPriority(character);
                    }
                }

                commonItems1 = null;
                commonItems2 = null;
                commonItems3 = null;
                groupCounter = 0;
            }
        }

        System.out.println(sumOfPriorities);
    }

    static String input = "LdHVLDLDdHdtLMhcqCqGWcWg\n" +
            "ZZQZSZnnJrQrJQJbfzfnWGWPWMcChMMPcqMnhFcF\n" +
            "ZrzpWzfbpQpWbzvZWZpdtVtDNmRHNVptNDHt\n" +
            "gzCjffWZCtCfZZVdqVSqJdvJndSt\n" +
            "hMHLcmGLMLhHmsRMsSvsQSqrsrlJTTdV\n" +
            "NPNGRGHGHNLczNzzZFWSFFCC\n" +
            "VSBpcvNNbNWWSfGRwtJnRtrzzGzGGn\n" +
            "jZlhTlQLHFLLZbwrzQQsttDtbs\n" +
            "hmmPFlhLmhLMgFMFLbMBBgcNVcfNCcfSVSSNBq\n" +
            "jRDSzjCjjMRMrHzMRCDHMDjBnlQbbnQwLwrNLPwnTPQrlc\n" +
            "sZBqdZqsWgFBpgppGJqllPllwnbQwTwsswQPwN\n" +
            "gJgtJJBtqJqWBGzjRCHDDzRmDtVV\n" +
            "GRBWbbWnGNhbwSsfPfmrlslWsS\n" +
            "HLVCgCLpMgcLVDcDCgmlvstSlsstPtSSSlscvl\n" +
            "LzQDQzMMzJzFQVDJgCzJHJZRZBNbqGFhNFwBGhbhBhBm\n" +
            "JNsHhdPZSdZJjSHzzNwvwGgBFmBmvptJbFvm\n" +
            "WrDrwqqqQWVMCvMvGbGbbFFbFp\n" +
            "rqqLncqnlCncwQWCwWlLfSZPsZddfzzNNdhdPlZz\n" +
            "rwfrwHqSdRcgwdZrDcrqDDdgNzjNjPzPJNJPtbNPbGsHNGHv\n" +
            "hllLMTLLQMCzJssPsTvtFG\n" +
            "QtQnpWVVMVWnVQpRZSSwZDggrcSq\n" +
            "FDlqPMBdmbqMrdDqqFdFDwjHZChHHZfZWZNBsZjhfhHf\n" +
            "VQJVgncpTQRJfsssGhsNWC\n" +
            "NtpLLSpcLVRzzRRtpgVcLgglMwwlPlzdmDlFmFPDmqqwlF\n" +
            "PqwwSqNWPqwSWqjNBwpTPpffhJfZfstRtZJRRdJsdR\n" +
            "VFLFzQVgVnDVjhdJHsvhZjfg\n" +
            "VVFVDDnmnzLFCzVmznFzrFlrjSCPNMBCSGSGwwwGBjPNWPwC\n" +
            "zzbCGrfgbzfzCtvqdjSrvSjnvS\n" +
            "cNVTLnJZRNNmQmhJNptvBlBtVjlljqqldtlB\n" +
            "ZhpcJHLQhRcLZLmNQJzfFwDzzgHPFngDPPnP\n" +
            "ttntdMMBZzbZZtjPfwjwTwBvvVmh\n" +
            "llSllRRNsGCrCDTPfgVgTfgvsjPH\n" +
            "CFclcCWGrJNDSnnWMbQTnWtLQd\n" +
            "bccfdSfwFsswcbbdJFGQVGnCJLnBLnDnQLDj\n" +
            "ThvHZNhZmqNWMNqvDVjcjjBQVhQBBVLB\n" +
            "vWMZZNRmNMWqtWqmqHclfFgdlwRwrzzSfwbFRd\n" +
            "WNzRWWZNmtNZnssNRPtCJFQJCffVJVffCvlF\n" +
            "cBqBLgHHBcgqBbCJjrvrVQJfsHlr\n" +
            "DhDShwchBSbdwBsqgGcbgTTRmzdNWmMRMmTdNpTMmW\n" +
            "FHWZDbbPZDFHgGGPdPbJNLpJSlNjcjSphcJjFN\n" +
            "ZCCrBBRwwCjcNwcljppN\n" +
            "CmTTsrMfBCRsTMnnCRTmVZbgdbdGfWHPDVvdbbPV\n" +
            "cgSNBScMgjBBPtBCNLVvVVvhhJJhvsMhVfWq\n" +
            "TFlDrHPZHTTFmwTQHZDZTrqvvzqlJppVJvpffhqqVfJp\n" +
            "DbPwrTZDQDRQQwQZrDrbbQwRRnNSBtCjtcNGjSgSLjLccC\n" +
            "pdcVCpdZnZgcZgdcDWBDNcNwvBWJwc\n" +
            "RRmHspRmmQfLwwJJbFBFFJNR\n" +
            "rGlpfrQrqGhGqdGP\n" +
            "THhNsHhdFjcDthDcjDhLBqWcLLQQJvvBbvBJbl\n" +
            "GfrCSZGCzfVMrVCCzGVfSMQBBFlJlJBFFZqvWBqbbQWl\n" +
            "rSrFwCwzMMzRfGrGMwPfGCVdgHDttthNPssHjmNNdDjgdD\n" +
            "shmhggDsZCZWBDmsQTcTqrLPTbNbwQQrrN\n" +
            "lzpFVfdjfFFGnVVHpjJGJVlprNMPNtPctTNwLtcTbwctwTnN\n" +
            "jVFfzVlFSpzpFCshWmgSRgmBRb\n" +
            "zZGFNPmdPdszdWddGWZlpLMLpbQbLDpblzQbtv\n" +
            "wTwgwSSCHhhCSghJbpcpDglbbQbMVMpV\n" +
            "BHnBRrJCHmRNfGDmfm\n" +
            "CffgvfCRGngRrvGvgdnRVpPQQPSqbVZZDPDVPzFSSQ\n" +
            "cMlWJTMlcTLTLtHHJlpqDLwqSzSSDDqDZDDS\n" +
            "tmHTtlMmWpmsMJsCRdCNsrRGfrnffN\n" +
            "lNrzNHNwzZlHmwNBpMqqnqGDZSpMTGnb\n" +
            "ddjgFjjsRvGvQhQvvFjqbVTFpbVpFDJSbJVpTS\n" +
            "cjsQhsjvRvGcgNtzczmtmwCCcr\n" +
            "NJMJvBmBJPtMtRDnDDwDMFFWDWHG\n" +
            "hZsrzshpSdjZZqSSfgpDwnwFnGCCLHDbjnGCWG\n" +
            "zfgSpScsrdpmllttGvJGcm\n" +
            "GLsnLVLZGZmcGVpgZLmTjTsDDTlDTHPPHWlHwD\n" +
            "dNJhCCdtNJSvdDzwPlvTlQ\n" +
            "BCbBrPPfRMfMJSffrMCMChrSqVcmLLFpqLFFcggLVnqgmbgc\n" +
            "hMdjMndZLRnRnjclszLclQlzGwcr\n" +
            "FPCCSCSpCwStJVGzsPQGslGzPbsQ\n" +
            "TSSJTtfTFTwtmTFFVFDTWRvdgndjjRhnjnvHjdfR\n" +
            "ZwgsnsWsWvWQHqJhGhJVCJHhCJ\n" +
            "cdjlMWRRMhJLCpLL\n" +
            "jjSRmRmNRNWBmdmcWjlDWFPswsPtnZQsnBsnZvvTTnvT\n" +
            "vvbjLTPbQzrQQjpLzLbflfjfRDDsDlRfgDnnVD\n" +
            "ZGCtHHFGzFHhMlCnDqwlgggsqf\n" +
            "FJHMhHZGmNHtJhMhBJZZtZdrbSbSzbmWLLQrQTbPdbrS\n" +
            "ZClGVCvLZzCLBVbdGGzVVBvVrqQMDWMHrgmgQLWrWmTgqqHH\n" +
            "tNpNspcQPfHmqfgHmHHg\n" +
            "nNttnwPRjFtPcccsFptPlllQGlQZbvGzVVVFzhCd\n" +
            "lflmVWpDVsMmmVPlHVbbGSSbGnSHJcncnLZn\n" +
            "NvTFzNwzTQvhFGSZnvgrbgJCgr\n" +
            "jtRwTQFzjBNGGQQBdDsDqqlsVqRflMlPsP\n" +
            "rCSJPCrBwwMdBJRCrwMTGWTWNbcjGZNGGZTb\n" +
            "qzgqfgFghsHzfgHgmmfWGNGGWcNNFClbWlcCNW\n" +
            "DqsnzsHLhddBDwCRJR\n" +
            "sZpHjZrVQmcrbhbthzhFHzhH\n" +
            "QDPMDMndqqQGqQfCDDbhFtzzLtbWzlBLLPBW\n" +
            "TDMDqfGnJSnfnfvgjsjNgJvsjVQv\n" +
            "bDZQbZHdQQggZfttJjGnplSnldsG\n" +
            "FTrFCvWBWzTNSPNvRBGJsGjpsJjstmCLtjCt\n" +
            "rhBvzRVRBBSVHDHcHMHq\n" +
            "FSbSNZbZbzGzGGbNzGgcZPwlDPvlNmLLLwLLlLvvvl\n" +
            "pqnqpVCrpshqmChsQnnRpRCldDHvDHLjDlvPwddlwPtwDV\n" +
            "rRTCnnpCWCChTrWsrBTfbcFFmFSSmfBBGg\n" +
            "QdhdWDsHhHWzPrLPSCPGvs\n" +
            "gpZZmNmtjZwpBZBZgSnvFcGPrrvmncnvmC\n" +
            "RVVRjZJfJVfVBZVtBNBVppZVDqMHhqTbMGlWHQhhWldRMHWd\n" +
            "BPWQrRRNNMhrHhLqqGgjDJjH\n" +
            "TzVmmpmtCNwscTzszcNzDCfCHJqDfGjDJJgfGCDq\n" +
            "wdwmspTsVdlTcpbmVMPWBbBWRPNnFnBWMr\n" +
            "VZTnVnsgrjjsqPzPwWgWPghz\n" +
            "mcFdQGPMBdMSBdWbhRzzWqwLwcWt\n" +
            "GQPBvpfvNvFPBvTnfjnZDHDDjsrr\n" +
            "CZssCNFJBmBNFmFBNwBFCJFTtthGrrSThtSgSRtSfRTGtRrg\n" +
            "LDpDbnjjDGpggGrvGg\n" +
            "PLMWnWQgbQWnWbnbjqDbszHwwzwmNsFZMBmwJFZF\n" +
            "hQSjFLhFLLMSSFgdWTMdGgNbNbWv\n" +
            "JmPlltJBJqmzpbrrwTwrvvGqww\n" +
            "HBzztRBRplzlmHmRmmsplRJZcfFcLFfHSLjSZTcfVVcLVH\n" +
            "nBSQMnVQqJBGnfVfDgCrjbVbtC\n" +
            "FNcPPHdTdhmBdHBvwlZjbClClfcZgjclgj\n" +
            "vFdHWhTLHvnBRRqBsWSR\n" +
            "TRsNNTTHRRZRRsRzJQddSpJLcQdpjs\n" +
            "DMVPVVGmMGWMGtMgGtDlmMWwLLLpJfSfpjzpdQddLSmSSJdc\n" +
            "tVMgGMDwMgMWDBWMttjRBZNnvNCNZrZZRbZNvZ\n" +
            "wlJPVMJPPBShSlhgfTvgNNzzgNMCTg\n" +
            "FLtRnDDSrvdNdrng\n" +
            "FcSmpFZFFmmjWqPWJbmhGqqm\n" +
            "hlBqqTlSfvNhpbfb\n" +
            "fRVsVDDRtnRVfbDNCCNCNQGwNZ\n" +
            "nrrRPPnHzntRrPsRVrtJVBMjlzWfFWdMjjWMqdBBlT\n" +
            "zDNcnRsNNfRFFNNzRzLbRWgMZMMZcdhcBdMrBpZmmZ\n" +
            "PVHHVlPDGPPtjDmmdrrGBBMpWGWd\n" +
            "VVqTTlQtDCqFNzsnbLbCSJ\n" +
            "ndSGSZZGwSZTBdwnwdwmWCzPQCQLffZzRgMZRggMzf\n" +
            "mvqVmqrmcDqllNNtbcNcMCQMRCMCCMQfHLgvRgMg\n" +
            "FhNNcrrVljFcqmTJhwnsmGdJsT\n" +
            "wlmLmZLwzvVmVWVmQWzZSFJFDSqFHSSFJHhDqZ\n" +
            "RsgpMNcMdRgjDcRFqCSrHSHBCFJr\n" +
            "jdncssDNPsbmmwvvlPLw\n" +
            "wQGHMrHGgwgVTQrrMGgGQrTtWzzPJhsfhZztWssQWbZCWh\n" +
            "FjvBFSqqDbljFvSbnvFltszfWPPfWzJZBCsPtJft\n" +
            "qLlDbpjFRbpdGTgLGLGTTV\n" +
            "hrVJsBrpwbsMZtTLlwnqtqdc\n" +
            "QDDmHWmffHCQWHjRQjCWczTTjtlzdldqVtTnTqLt\n" +
            "HmfGfRNWfNWmQCRsgbsMFMhMGvpBVs\n" +
            "CRzzVCZhvGQqNmcWrgpgwQFSmF\n" +
            "BJsttjDtjbdLMHHsBTqBbBHMrprDSrFnFnSgrnnrpDSmWWnw\n" +
            "TbMBMPPdLTbHTjHMtPzZGvzlvqCPGNlNVRVP\n" +
            "QcmcrCVcdTCGRRLT\n" +
            "zzgWFWVBTSWLPdMP\n" +
            "JbhnBVzzfVhgztVDvqcqHwncZHNqnsnccQ\n" +
            "JJVBFfJjNNNsJTwVfZJNffFRpRzRzRptRWtCtSSHWsWzCD\n" +
            "rmrnhgclhQGcGnhrPjqgGMHbWRHRbRCWbzRbMSSpHWCD\n" +
            "mhhjQGGjQgggqnmQnmghdQdJFZBNvZBBLNTvvTNNTLfZ\n" +
            "DrBgwMCMRvMrvDgPCzdpdNtzqqlHNNtp\n" +
            "jWSSZGgfGjcLfdNjFzqqFFzzFF\n" +
            "nGZhTmZLLZhGPVVTgQgMRrrb\n" +
            "ppqZvppdJmSLHdSfZRrrtbscgRVVgwVrHt\n" +
            "hFFFzQPhNWzNhnhGVggrcbwVgBnvbwgR\n" +
            "CNQWFMzWWhCflpjvZJMJdj\n" +
            "pfpfmQMWmcBVfMBBmpfVQMbDGGNPDTcSNTTsSNPCCNhC\n" +
            "ZZrZwvvzZrvZlZlwhwswhNSsgbDssC\n" +
            "ttvdtzRzFDqRJWLVLWJJpQ\n" +
            "CZZPTQPTPTJhTQTrHCBbvtLbbbRWtjbDvb\n" +
            "cGfsVSVcLdSgSwBWRNNGwRNRbD\n" +
            "spSffnccsgcdnnJJQlZZqJLhpMJh\n" +
            "TwGGdWwdddtTsbzPzbbnTLnPLP\n" +
            "gqNSMvtvcSDLLfnMnnPzFM\n" +
            "NvDNDqtvRcjQVGZZGZZhwpQB\n" +
            "jtgFmnqjqttQpsphzNllblzlNH\n" +
            "GRMRDMGCVCHzSCbSbNNl\n" +
            "LMTJRTGRLBJBwLRRHmBFQPvqmPBvtgtc\n" +
            "jDjjwRDpPqqsMsDLJbJzVB\n" +
            "lMNMNddvMltNfFVWbVVWJrrVLfgL\n" +
            "NQQtmtFGFlGZPZcMmmcjjn\n" +
            "CgCNjvSCgSQQzVZNWVnTBPTcsTVBnpPs\n" +
            "bFbbLfbfdRBFhLwqFmblBJfRHtWcttcttlDpspcPWDcDptPn\n" +
            "mdbFhfJrmJwfbmmFFFvBZCNCzMGrNjMQjCCZ\n" +
            "TPDNHHSTNNmRfTrRMZSqwwttdbBvBMth\n" +
            "VVnnFGgnQcBvMqvnhNBN\n" +
            "GLzjjzGscssJGJCHljmfmTWPTCDN\n" +
            "BZZNcMQjBNjNtDJgstjgtwqGRQfhGhSvPfThfqvPhfhf\n" +
            "CCndrnmnnWbrnHrFbWbpbbVmGGPqLfTGhvGSPhqRLRdfSGsf\n" +
            "bFssVbbblFHzrmFlMNMtcNgDtJDzZgtw\n" +
            "smjMtSqQQSjtSfmDVVFHFhnHBHmbNPPH\n" +
            "TgvCCJcZdwdgNvbHvPbbvBNq\n" +
            "JLqRWTgLqJLCJcclgCJdWjfsSSpsfRrsQjDtspptQQ\n" +
            "hNwztzgzJnnNTVFwNTNhwVhZlrpLMLZZlpZlQndLPLpQLZ\n" +
            "vRDvqSSqjbqSWDvjbvBdLWspPLddZPQQLMllLp\n" +
            "SfGfRmSGCSfBfjTcNFgzwMFJzwgm\n" +
            "lhVBhZjjPHbThwFGrNrdvNNwFV\n" +
            "DRrDLfMLSgpCdCJcfmcJCm\n" +
            "LQtnprtqSRtZjHzTthlb\n" +
            "GrGsqfbtsWGWWntnrrwWWWGSSDSMDcSSSwTDzPzJSJzPcT\n" +
            "lmQhhVCgmffCNgmNNmCmBNRRPvDzDMhJvSSDJzzcTzvvPvMT\n" +
            "VBllNBpfQgQmpLBpRBtnqWLFFnZZWWGrZrjq\n" +
            "NRJdngMVwfgnwJtvlblcWLlLDHfccDbW\n" +
            "PFJzBmhmjPFpJrFqLcQHLlHGDlHDQbGz\n" +
            "ShJZJmPFpwdMvCCZRd\n" +
            "WQDqSVWqpBCsPqPWWNscfrHfhrhrHhGFGs\n" +
            "MmLRmLTjmTzTzlhGHfprhvfFhHfT\n" +
            "mLZLRdgMRjtdddmdgwmtMwQSCPbnDSSCqBDwpWPQqn\n" +
            "rNHwMMGDrggWwsvWMPMWWwjbCqjCBlZqvfjBqCJhfffj\n" +
            "FbtFmRTpzBBZqCClpJ\n" +
            "ztbzFtnzVNnNNPPDGD\n" +
            "PLPFcwdLdFcbgdfSwFtWhGWGRMWMJMGCblJR\n" +
            "qTpszVVjRlCHtWCT\n" +
            "qzvrDqQrqznzggFZwFwQScdW\n" +
            "LWLjLNjNjTwlwLZVcBVcVVZcBVQcZZ\n" +
            "JhGhFdmBRdGGDnQtbPvVVdnccS\n" +
            "zDrrFGFFRgRHmDNWTpjTBNTHWNjW\n" +
            "fwfBVLhmwfhHsgBstWCWQnDQnlldWW\n" +
            "hZvFTNJrZjZbFvNvttqWWDtcWqCtFDWn\n" +
            "rbjjrjpRzRzgBLzwLgmzLh\n" +
            "ZqqqWVzdSPnwBJBfwJfZTs\n" +
            "FHGgjRLMJFsJTsBw\n" +
            "DHRcDgHvLhDWPSCzwqnq\n" +
            "LZGZLLRLZpRQBtPTjTffrHljjmsB\n" +
            "wNVVwcCgNCCScwggmjHjTPmQPsTHmlSs\n" +
            "gbbwbqhNCQcbqqVchWhtRZDJWJDtZLWL\n" +
            "CmTmvvmvzCCCgzzVQmTQvTjjGRGShwSHwRrRSSSSDNHSFN\n" +
            "PqZqWdqlplsqBJMMsMMnGRJRbbNwNhrrhShGShFD\n" +
            "fBWBWdZppqpqDMBdlfcTCTLtLtLCQfQvcmgv\n" +
            "pntdtdHHWHqnptGpqHqNgMQwPPPnZMZZZZcfgc\n" +
            "LFmLSVBRTSBBRrffTQgMfQMtJZQT\n" +
            "bmRCSSSjRCtSrRChjqqGqpppGhqDGp\n" +
            "dGGhhfNfgRTGLcpL\n" +
            "BmCCwQMQqmQrBCBJLpbVTFbHcgcbLTMc\n" +
            "JrpqJJmqqqqmzqqwmwNlzfvltDPltfshlhNN\n" +
            "VCCbMJfJlgRCnNGVNnvFvVBF\n" +
            "STsgcZdghZsqSttBnsGnBtBtHt\n" +
            "qDcjgDphjhSghZTQgCJWQWWfwfRzWlwJzJ\n" +
            "JHMVMvmvRcdbmrRHQBBGjcjfFQfChSfj\n" +
            "NltNtZllgZtgtnpnqNWpgCrCBQzBGzFhQrGSSBCzWh\n" +
            "pDrwnqLlvDVmPbss\n" +
            "dbrpbSrwBjswsSjCwqllLqFtqLcrGqqFtF\n" +
            "RvfJDQnRpHvvQfRvvQRJFDqzcWltFFlzcLttWltW\n" +
            "ZpnRVZHmvHnTnPZZPHfHmVwdjVghwgVSBgdBBCwgdC\n" +
            "WRCBGWvNgHnMcFwnpC\n" +
            "ltlstrjlJNlfrZZqDJtNLsHnmwwpcHphhFPMFjwhmnFp\n" +
            "TStJssLstJLtqTsNgvvSBNzzvWvGRz\n" +
            "VBjdWdGcqWdBVCFRmHwfCRRV\n" +
            "DLzNpqbDzDNbrJvltMLJLRRmtRFTSRmTmFwfRHRTFf\n" +
            "zvvJNLgNqGcnjgnP\n" +
            "JjdnFfbdbdQMbQzjtRcwcCvbvBqRBCwt\n" +
            "LlNHlWGprPCVVBsVzqNR\n" +
            "hLmgTlrpPPHrLprHrTTGggHWzhZFSJDfhMdnjjZfFfdFMjFz\n" +
            "bDbwRpCSRgqqMfMf\n" +
            "HzzPcPnhzlhsQzHhHnTggBBqTQTgVQqBqjZW\n" +
            "tnsrFccnzsDvGpNGqNtq\n" +
            "GmPsPrsSlswNmcLzMvnpnmMpLBCf\n" +
            "glDTZRDqRTjRCvjvfBpfCzvp\n" +
            "DHlJVhJRDTbqZDqSNVrNwtVrQwSSGs\n" +
            "nNnDwqDwFVgDwDnCgLnLpCVWdBMRpsPdMPPjRHRHHRdBWj\n" +
            "tQtfTtJtJmlTQrTtTlhfzrmdHzMMRMsBPPddjddBPPdWsB\n" +
            "bbhtQTfTTsmmbStnqGFGNDbFDgFVnw\n" +
            "dsVpDPBMHVdHpplpvdHjRjmmjRTMTFFrrTTFQq\n" +
            "LzzWZLGCzCWNjfmRfBhmQjZq\n" +
            "zSSSwJwSBzNtzLBbwbSGLzWVvcvpHdssDllVJgVHVcdDPv\n" +
            "RWfQBDTBLQWpDLNRZjZwHHddjHNhZdtv\n" +
            "ScCCzSszFzJccPHHvmjHvjhpmHsj\n" +
            "FPclgFVCbcngVgnpWQqqRfLBDBrR\n" +
            "cRLLVwcsctwmbVcszztwtRMvNrCpTggqFrTvvhCVpghBqh\n" +
            "PdSDGdnZQfGDfDjWjWWgvCqFhpqvpNZgCTTvrp\n" +
            "dGnDHWnSQdJPDSFLLcJmRzzLLLRRcl\n" +
            "lCSqlcCcBqBCCwGwnNWnnFwBHF\n" +
            "WMZLMPbPhQddRbMpbbLbRLLHDFgjFGDmFNZgNnDGNHGGjD\n" +
            "dTVPPQbPbMdQMzvVrWvczrCJqv\n" +
            "vzscdHcHZzHzCCHlQTTTCcslMGPStmSlpDDSSSgSPDNBmNtl\n" +
            "FWVMFhFMMqWhFVFbDBDDhpmpGtPSDpGG\n" +
            "fRLbFfwWWLnVjMdzzQHQJnnvQs\n" +
            "SmPdRbWZdSqqzSPmbdWFFQgcQnvncgQGQMMT\n" +
            "BfBLmVNjprVVNlVBrpBlHpNrgQFHGCGgvTQTMGFFgMCvgQcQ\n" +
            "BjjJfVLBfNffJbZDqtDsdzzm\n" +
            "NLgtLsSggjqgqpLLDjsjmcJfvpmFmmJmvPpwhBJB\n" +
            "lMnlZMtdCMrRRnRbTddWbVwcmPfFmhJwPfwJmvfwFvPl\n" +
            "MnRrnGWRbgQqtNGDjt\n" +
            "dSdrTbTtLJCcttcFVw\n" +
            "PhsgQQGPZshvpQZGgsrBllVFlHVpFllJJrFH\n" +
            "gqsGPgMZhgvQbzrzTfSzMTLf\n" +
            "pqbDdQWqCgBfbbfFfB\n" +
            "vtjnmzLcmhBdzTFgTsRP\n" +
            "LZGmjvJGGctnLtvcchSjmhcLqNHCwVdQZwDwWDNpCwqHdDwQ\n" +
            "wlMWSSHWShSMbDSwVhCrNjJmcrDmGRRCGCjN\n" +
            "FHZdHftFFQnqsQqsQttjvGrJccmdGGcrNdRNmG\n" +
            "pHpzPpQHpsPzPlzlbSgSSMLwzh\n" +
            "fCQDLlDQTSjbHDqH\n" +
            "ZhrsrZZZhcclwNswGGwbwF\n" +
            "rcWhlhlpMJpMZmgtBCzCttCCRfdp\n" +
            "zLnCMLNTvtGNpNvNjhRHgZhHvZdZHdjD\n" +
            "fSsWWqScTfJJqfJFFJwswhdHhhhdhDdjbjZbhhDj\n" +
            "WsWmfcqBWfTfsrntrLmplCLttm\n" +
            "ljssbqMMPbHPlsbcWZNLLsWJWRFvvZfW\n" +
            "SzgggDDwTzrQmDQgdSSWvdJLFGffRvZG\n" +
            "zCzCDCrznnTTmCbbpvlPHtCPtb\n" +
            "TZSwNPpcgpNPbwbhhbwrwJqh\n" +
            "BlCDtvvgLWGCLffGfLzLrMqnnbDDHbmnnnJrhnVJ\n" +
            "lzBjdCjCGCjfGjjLGBGGjlCSsRppcdpRNdRSPQcRPQZTgT\n" +
            "TsFTrvGmZGfvZfZFzNNZrhClmRcBgCMwQwQPCPMPRP\n" +
            "bpnnVVJtSDgRBwbQRwlR\n" +
            "jpSnqLpqDJDJLDjWDWLWvvzfZZvqvNsGTHGGFfZl\n" +
            "bzbzznqfCpzvhCSMfbCbpCFhtHGHHJdtHJGhFsmshJJG\n" +
            "DLWRLjRrmNPQjZZlQPsFGFggVcWcFddggdsg\n" +
            "rjrZPwwDRlLLBjQlRRlPDpmbqzpqnnCSCfTMwMqSvC\n" +
            "FmcGcjLRPjQwQjMQrwHQ\n" +
            "btJzJbVNdBJJtzTdGBbdBztGrQhhQWhMwHrhrHSHgHQfhMVS\n" +
            "JJDpdDTtCtzNptnTJBznnvLCCvcFqsRqFcvZclLGRR\n";

}

