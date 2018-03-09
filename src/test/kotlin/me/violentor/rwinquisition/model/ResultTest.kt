package me.violentor.rwinquisition.model

import io.kotlintest.matchers.*
import io.kotlintest.specs.StringSpec
import me.violentor.rwinquisition.model.result.ConverterImpl
import me.violentor.rwinquisition.model.result.Result

class ResultModelTests: StringSpec(){

    val resultJson = this::class.java.classLoader.getResource("mac.json").readText()
    val result: Result = ConverterImpl.fromJsonString(resultJson)
    val reverseResult: String = ConverterImpl.toJsonString(result)

    init {
        "Result version should be 2.0.32" {
            result.version shouldBe "2.0.32"
        }

        "Results should have statistics" {
            result.statistics!!.duration shouldBe 57.447338
        }

        "Results should describe platform" {
            result.platform!!.name shouldBe "mac_os_x"
            result.platform!!.release shouldBe "17.4.0"
        }

        "Results should describe profile" {
            result.profiles!![0].name shouldBe "cis-appleosx10.11-level2"
            result.profiles!![0].version shouldBe "1.0.0"
            result.profiles!![0].sha256 shouldBe "f623bb37c6e7fba43c7d68be805a06824fb073bef361897c2e3a62c0e5bda4eb"
            result.profiles!![0].title shouldBe "CIS Apple OSX 10.11 Benchmark Level 2"
            result.profiles!![0].maintainer shouldBe "Chef Software, Inc."
            result.profiles!![0].summary shouldBe "CIS Apple OSX 10.11 Benchmark Level 2 translated from SCAP"
            result.profiles!![0].license shouldBe "Proprietary, All rights reserved"
            result.profiles!![0].copyright shouldBe "Chef Software, Inc."
            result.profiles!![0].copyrightEmail shouldBe "support@chef.io"
            result.profiles!![0].supports?. should(beEmpty())
            result.profiles!![0].attributes?. should(beEmpty())
        }

        "Results should include specific controls"{
            result.profiles!![0].groups!![0].controls?. should(containsAll(
                    "xccdf_org.cisecurity.benchmarks_rule_1.1_Verify_all_Apple_provided_software_is_current",
                    "xccdf_org.cisecurity.benchmarks_rule_1.2_Enable_Auto_Update",
                    "xccdf_org.cisecurity.benchmarks_rule_1.3_Enable_app_update_installs",
                    "xccdf_org.cisecurity.benchmarks_rule_1.4_Enable_system_data_files_and_security_update_installs",
                    "xccdf_org.cisecurity.benchmarks_rule_1.5_Enable_OS_X_update_installs",
                    "xccdf_org.cisecurity.benchmarks_rule_2.1.1_Turn_off_Bluetooth_if_no_paired_devices_exist",
                    "xccdf_org.cisecurity.benchmarks_rule_2.1.2_Turn_off_Bluetooth_Discoverable_mode_when_not_pairing_devices",
                    "xccdf_org.cisecurity.benchmarks_rule_2.1.3_Show_Bluetooth_status_in_menu_bar",
                    "xccdf_org.cisecurity.benchmarks_rule_2.2.1_Enable_Set_time_and_date_automatically",
                    "xccdf_org.cisecurity.benchmarks_rule_2.2.2_Ensure_time_set_is_within_appropriate_limits",
                    "xccdf_org.cisecurity.benchmarks_rule_2.3.1_Set_an_inactivity_interval_of_20_minutes_or_less_for_the_screen_saver",
                    "xccdf_org.cisecurity.benchmarks_rule_2.3.2_Secure_screen_saver_corners",
                    "xccdf_org.cisecurity.benchmarks_rule_2.3.3_Verify_Display_Sleep_is_set_to_a_value_larger_than_the_Screen_Saver",
                    "xccdf_org.cisecurity.benchmarks_rule_2.3.4_Set_a_screen_corner_to_Start_Screen_Saver",
                    "xccdf_org.cisecurity.benchmarks_rule_2.4.1_Disable_Remote_Apple_Events",
                    "xccdf_org.cisecurity.benchmarks_rule_2.4.2_Disable_Internet_Sharing",
                    "xccdf_org.cisecurity.benchmarks_rule_2.4.3_Disable_Screen_Sharing",
                    "xccdf_org.cisecurity.benchmarks_rule_2.4.4_Disable_Printer_Sharing",
                    "xccdf_org.cisecurity.benchmarks_rule_2.4.5_Disable_Remote_Login",
                    "xccdf_org.cisecurity.benchmarks_rule_2.4.6_Disable_DVD_or_CD_Sharing",
                    "xccdf_org.cisecurity.benchmarks_rule_2.4.7_Disable_Bluetooth_Sharing",
                    "xccdf_org.cisecurity.benchmarks_rule_2.4.8_Disable_File_Sharing",
                    "xccdf_org.cisecurity.benchmarks_rule_2.4.9_Disable_Remote_Management",
                    "xccdf_org.cisecurity.benchmarks_rule_2.5.1_Disable_Wake_for_network_access",
                    "xccdf_org.cisecurity.benchmarks_rule_2.5.2_Disable_sleeping_the_computer_when_connected_to_power",
                    "xccdf_org.cisecurity.benchmarks_rule_2.6.1_Enable_FileVault",
                    "xccdf_org.cisecurity.benchmarks_rule_2.6.2_Enable_Gatekeeper",
                    "xccdf_org.cisecurity.benchmarks_rule_2.6.3_Enable_Firewall",
                    "xccdf_org.cisecurity.benchmarks_rule_2.6.4_Enable_Firewall_Stealth_Mode",
                    "xccdf_org.cisecurity.benchmarks_rule_2.6.5_Review_Application_Firewall_Rules",
                    "xccdf_org.cisecurity.benchmarks_rule_2.7.1_iCloud_configuration",
                    "xccdf_org.cisecurity.benchmarks_rule_2.7.2_iCloud_keychain",
                    "xccdf_org.cisecurity.benchmarks_rule_2.7.3_iCloud_Drive",
                    "xccdf_org.cisecurity.benchmarks_rule_2.8_Pair_the_remote_control_infrared_receiver_if_enabled",
                    "xccdf_org.cisecurity.benchmarks_rule_2.9_Enable_Secure_Keyboard_Entry_in_terminal.app",
                    "xccdf_org.cisecurity.benchmarks_rule_2.10_Java_6_is_not_the_default_Java_runtime",
                    "xccdf_org.cisecurity.benchmarks_rule_2.11_Securely_delete_files_as_needed",
                    "xccdf_org.cisecurity.benchmarks_rule_3.1.1_Retain_system.log_for_90_or_more_days",
                    "xccdf_org.cisecurity.benchmarks_rule_3.1.2_Retain_appfirewall.log_for_90_or_more_days",
                    "xccdf_org.cisecurity.benchmarks_rule_3.1.3_Retain_authd.log_for_90_or_more_days",
                    "xccdf_org.cisecurity.benchmarks_rule_3.2_Enable_security_auditing",
                    "xccdf_org.cisecurity.benchmarks_rule_3.3_Configure_Security_Auditing_Flags",
                    "xccdf_org.cisecurity.benchmarks_rule_3.4_Enable_remote_logging_for_Desktops_on_trusted_networks",
                    "xccdf_org.cisecurity.benchmarks_rule_3.5_Retain_install.log_for_365_or_more_days",
                    "xccdf_org.cisecurity.benchmarks_rule_4.1_Disable_Bonjour_advertising_service",
                    "xccdf_org.cisecurity.benchmarks_rule_4.2_Enable_Show_Wi-Fi_status_in_menu_bar",
                    "xccdf_org.cisecurity.benchmarks_rule_4.3_Create_network_specific_locations",
                    "xccdf_org.cisecurity.benchmarks_rule_4.4_Ensure_http_server_is_not_running",
                    "xccdf_org.cisecurity.benchmarks_rule_4.5_Ensure_ftp_server_is_not_running",
                    "xccdf_org.cisecurity.benchmarks_rule_4.6_Ensure_nfs_server_is_not_running",
                    "xccdf_org.cisecurity.benchmarks_rule_5.1.1_Secure_Home_Folders",
                    "xccdf_org.cisecurity.benchmarks_rule_5.1.2_Check_System_Wide_Applications_for_appropriate_permissions",
                    "xccdf_org.cisecurity.benchmarks_rule_5.1.3_Check_System_folder_for_world_writable_files",
                    "xccdf_org.cisecurity.benchmarks_rule_5.1.4_Check_Library_folder_for_world_writable_files",
                    "xccdf_org.cisecurity.benchmarks_rule_5.2.1_Configure_account_lockout_threshold",
                    "xccdf_org.cisecurity.benchmarks_rule_5.2.2_Set_a_minimum_password_length",
                    "xccdf_org.cisecurity.benchmarks_rule_5.2.3_Complex_passwords_must_contain_an_Alphabetic_Character",
                    "xccdf_org.cisecurity.benchmarks_rule_5.2.4_Complex_passwords_must_contain_a_Numeric_Character",
                    "xccdf_org.cisecurity.benchmarks_rule_5.2.5_Complex_passwords_must_contain_a_Special_Character",
                    "xccdf_org.cisecurity.benchmarks_rule_5.2.6_Complex_passwords_must_uppercase_and_lowercase_letters",
                    "xccdf_org.cisecurity.benchmarks_rule_5.2.7_Password_Age",
                    "xccdf_org.cisecurity.benchmarks_rule_5.2.8_Password_History",
                    "xccdf_org.cisecurity.benchmarks_rule_5.3_Reduce_the_sudo_timeout_period",
                    "xccdf_org.cisecurity.benchmarks_rule_5.4_Automatically_lock_the_login_keychain_for_inactivity",
                    "xccdf_org.cisecurity.benchmarks_rule_5.5_Ensure_login_keychain_is_locked_when_the_computer_sleeps",
                    "xccdf_org.cisecurity.benchmarks_rule_5.6_Enable_OCSP_and_CRL_certificate_checking",
                    "xccdf_org.cisecurity.benchmarks_rule_5.7_Do_not_enable_the_root_account",
                    "xccdf_org.cisecurity.benchmarks_rule_5.8_Disable_automatic_login",
                    "xccdf_org.cisecurity.benchmarks_rule_5.9_Require_a_password_to_wake_the_computer_from_sleep_or_screen_saver",
                    "xccdf_org.cisecurity.benchmarks_rule_5.10_Require_an_administrator_password_to_access_system-wide_preferences",
                    "xccdf_org.cisecurity.benchmarks_rule_5.11_Disable_ability_to_login_to_another_users_active_and_locked_session",
                    "xccdf_org.cisecurity.benchmarks_rule_5.12_Create_a_custom_message_for_the_Login_Screen",
                    "xccdf_org.cisecurity.benchmarks_rule_5.13_Create_a_Login_window_banner",
                    "xccdf_org.cisecurity.benchmarks_rule_5.14_Do_not_enter_a_password-related_hint",
                    "xccdf_org.cisecurity.benchmarks_rule_5.15_Disable_Fast_User_Switching",
                    "xccdf_org.cisecurity.benchmarks_rule_5.16_Secure_individual_keychains_and_items",
                    "xccdf_org.cisecurity.benchmarks_rule_5.17_Create_specialized_keychains_for_different_purposes",
                    "xccdf_org.cisecurity.benchmarks_rule_5.18_System_Integrity_Protection_status",
                    "xccdf_org.cisecurity.benchmarks_rule_5.19_Install_an_approved_tokend_for_smartcard_authentication_",
                    "xccdf_org.cisecurity.benchmarks_rule_6.1.1_Display_login_window_as_name_and_password",
                    "xccdf_org.cisecurity.benchmarks_rule_6.1.2_Disable_Show_password_hints",
                    "xccdf_org.cisecurity.benchmarks_rule_6.1.3_Disable_guest_account_login",
                    "xccdf_org.cisecurity.benchmarks_rule_6.1.4_Disable_Allow_guests_to_connect_to_shared_folders",
                    "xccdf_org.cisecurity.benchmarks_rule_6.2_Turn_on_filename_extensions",
                    "xccdf_org.cisecurity.benchmarks_rule_6.3_Disable_the_automatic_run_of_safe_files_in_Safari",
                    "xccdf_org.cisecurity.benchmarks_rule_6.4_Use_parental_controls_for_systems_that_are_not_centrally_managed",
                    "xccdf_org.cisecurity.benchmarks_rule_7.1_Wireless_technology_on_OS_X",
                    "xccdf_org.cisecurity.benchmarks_rule_7.2_iSight_Camera_Privacy_and_Confidentiality_Concerns",
                    "xccdf_org.cisecurity.benchmarks_rule_7.3_Computer_Name_Considerations",
                    "xccdf_org.cisecurity.benchmarks_rule_7.4_Software_Inventory_Considerations",
                    "xccdf_org.cisecurity.benchmarks_rule_7.5_Firewall_Consideration",
                    "xccdf_org.cisecurity.benchmarks_rule_7.6_Automatic_Actions_for_Optical_Media",
                    "xccdf_org.cisecurity.benchmarks_rule_7.7_App_Store_Automatically_download_apps_purchased_on_other_Macs_Considerations",
                    "xccdf_org.cisecurity.benchmarks_rule_7.8_Extensible_Firmware_Interface_EFI_password",
                    "xccdf_org.cisecurity.benchmarks_rule_7.9_Apple_ID_password_reset",
                    "xccdf_org.cisecurity.benchmarks_rule_7.10_Repairing_permissions_is_no_longer_needed_with_10.11",
                    "xccdf_org.cisecurity.benchmarks_rule_7.11_App_Store_Password_Settings",
                    "xccdf_org.cisecurity.benchmarks_rule_8.1_Password_Policy_Plist_generated_through_OS_X_Server",
                    "xccdf_org.cisecurity.benchmarks_rule_8.2_Password_Policy_Plist_from_man_page"))
        }

        "reverse convertion should go correctly too" {
            reverseResult.toLowerCase() should {
                startWith("{\"platform\":{\"name\":\"mac_os_x\"")
                include("\"start_time\":\"2018-03-08t18:55:50+03:00\"")
                endWith("\"statistics\":{\"duration\":57.447338},\"version\":\"2.0.32\"}")
            }
        }
    }
}